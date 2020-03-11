package chapter10;

import java.util.ArrayList;
import java.util.List;

public class Decorator {
    public static void main(String[] args) {
       // DisplayDecorator roadWithLane = new LaneDecorator(new RoadDisplay());
       // roadWithLane.draw();
       // DisplayDecorator roadWithTraffic = new TrafficDecorator(new RoadDisplay());
       // roadWithTraffic.draw();
       // Display roadWithLaneAndTraffic = new LaneDecorator(new TrafficDecorator(new RoadDisplay()));
       // roadWithLaneAndTraffic.draw();

        List<String> decoratorList = new ArrayList<>();
      //  decoratorList.add("Lane");
        decoratorList.add("Traffic");

        Display road = new RoadDisplay();
        for(String decoratorName: decoratorList) {
            if (decoratorName.equalsIgnoreCase("Lane"))
                road = new LaneDecorator(road); // 차선 표시르 기능을 동적으로 추가
            if (decoratorName.equalsIgnoreCase("Traffic"))
                road = new TrafficDecorator(road); // 차선 표시를 기능을 동적으로 추가
        }
        road.draw();
    }
}

abstract class Display {
    abstract void draw();
}

class RoadDisplay extends Display { // 기본 도로 표시 클래스
    public void draw() {
        System.out.println("기본 도로 표시");
    }
}

abstract class DisplayDecorator extends Display {
    private Display decoratedDisplay;

    public DisplayDecorator(Display decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }
    public void draw() {
        decoratedDisplay.draw();
    }
}

class LaneDecorator extends DisplayDecorator { // 차선 표시를 추가하는 클래스
    public LaneDecorator(Display decoratedDisplay) {
        super(decoratedDisplay); // 기존 표시 클래스의 설정
    }

    @Override
    public void draw() {
        super.draw(); // 상위 클래스의 draw 메소드를 호출해서 기본 도로를 표시한다.
        drawLine(); // 추가적으로 차선을 표시
    }
    private void drawLine() {
        System.out.println("\t차선 표시");
    }
}

class TrafficDecorator extends DisplayDecorator { // 교통량 표시를 추가하는 클래스

    public TrafficDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw(); // 상위 클래스의 draw 메소드를 호출해서 기본 도로를 표시한다.
        drawTraffic(); // 교통량 표시
    }
    private void drawTraffic() {
        System.out.println("\t교통량 표시");
    }
}

