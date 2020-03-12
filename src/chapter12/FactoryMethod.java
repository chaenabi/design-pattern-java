package chapter12;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FactoryMethod {
    public static void main(String[] args) {
        ElevatorManager emWithResponseTimeScheduler = new ElevatorManagerWithResponseTimeScheduling(2);
        emWithResponseTimeScheduler.requestElevator(10, Direction.UP);

        ElevatorManager emWithThroughputScheduler = new ElevatorManagerWithThroughputScheduling(2);
        emWithThroughputScheduler.requestElevator(20, Direction.UP);

        ElevatorManager emWithDynamicScheduler = new ElevatorManagerWithDynamicScheduling(2);
        emWithDynamicScheduler.requestElevator(10, Direction.DOWN);
    }
}


enum Direction {
    UP, DOWN
}

abstract class ElevatorManager {
    private List<ElevatorController> controllers; //엘리베이터 당 컨트롤러 하나여야 하므로.

    // 주어진 수만큼의 ElevatorController 를 생성함
    public ElevatorManager(int controllerCount) {
        controllers = new ArrayList<>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i + 1);
            controllers.add(controller);
        }

    }

    protected abstract ElevatorScheduler getScheduler(); // Primitive Type 또는 hook 메서드

    void requestElevator(int destination, Direction direction) { // 템플릿 메소드.
        // 히위 클래스에서 오버라이드된 getScheduler 를 호출함.
        ElevatorScheduler scheduler = getScheduler();
        System.out.println(scheduler);
        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);
    }

}

class ElevatorController {
    private int id;
    private int curFloor; // 현재층

    public ElevatorController(int id) {
        this.id = id;
        curFloor = 1;
    }

    public void gotoFloor(int destination) {
        System.out.print("Elevator [" + id + "] Floor: " + curFloor);
        curFloor = destination;
        System.out.println(" ==> " + curFloor);
    }
}

class ThroughputScheduler implements ElevatorScheduler {
    private static ElevatorScheduler scheduler;

    private ThroughputScheduler() {
    }

    public static ElevatorScheduler getInstance() {
        if (scheduler == null)
            scheduler = new ThroughputScheduler();
        return scheduler;
    }

    public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
        return 0;
    }
}

interface ElevatorScheduler {
    int selectElevator(ElevatorManager manager, int destination, Direction direction);
}

class ResponseTimeScheduler implements ElevatorScheduler {
    private static ElevatorScheduler scheduler;

    private ResponseTimeScheduler() {
    }

    public static ElevatorScheduler getInstance() {
        if (scheduler == null)
            scheduler = new ResponseTimeScheduler();
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
        return 0;
    }
}

class ElevatorManagerWithThroughputScheduling extends ElevatorManager {

    public ElevatorManagerWithThroughputScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() { // 처리량 최대화 전략을 사용함.
        return ThroughputScheduler.getInstance();
    }


}

class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager {

    public ElevatorManagerWithResponseTimeScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() { // 대기 시간 최소화 전략을 사용함.
        return ResponseTimeScheduler.getInstance();
    }


}


class ElevatorManagerWithDynamicScheduling extends ElevatorManager {
    public ElevatorManagerWithDynamicScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() { // 동적 스케줄링을 사용함.
        ElevatorScheduler scheduler;

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour > 12) // 오전
             scheduler = ResponseTimeScheduler.getInstance();
        else // 오후
            scheduler = ThroughputScheduler.getInstance();
        return scheduler;
    }

}