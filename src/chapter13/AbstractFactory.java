package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AbstractFactory {
    public static void main(String[] args) {
        ElevatorFactory factory = null;

        String vendorName = "Hyundai";
        if(vendorName.equalsIgnoreCase("LG")) {
            factory = new LGElevatorFactory();
        }
        else {
            factory = new HyundaiElevatorFactory();
        }

        Door door = factory.createDoor();
        Motor motor = factory.createMotor();
        motor.setDoor(door);

        door.open();
        motor.move(Direction.UP);
    }

}


enum DoorStatus {
    OPENED, CLOSED
}
enum Direction {
    UP, DOWN
}
enum MotorStatus {
    MOVING, STOPPED
}

abstract class Door {
    private DoorStatus doorStatus;

    public Door() {
        doorStatus = DoorStatus.CLOSED;
    }
    public DoorStatus getDoorStatus() {
        return doorStatus;
    }
    public void close() { // 템플릿 메서드
        if(doorStatus == DoorStatus.CLOSED) // 이미 문이 닫혀 있으면 아무 동작을 하지 않음
            return;

        doClose(); // 실제로 문을 닫는 동작을 수행함, 하위 클래스에서 오버라이드될 것임.
        doorStatus = DoorStatus.CLOSED;
    }
    public void open() {
        if(doorStatus == DoorStatus.CLOSED) // 문의 상태를 닫힘으로 기록함.
            return;

        doOpen(); // 실제로 문을 여는 동작을 수행함. 하위 클래스에서 오버라이드 될 것임.
        doorStatus = DoorStatus.OPENED; // 문의 상태를 열림으로 기록함.
    }

    protected abstract void doClose(); // primitive 혹은 hook 메서드
    protected abstract void doOpen();  // primitive 혹은 hook 메서드

}

class LGDoor extends Door {

    @Override
    protected void doClose() {
        System.out.println("Close LG Door");
    }

    @Override
    protected void doOpen() {
        System.out.println("Open LG Door");
    }
}

class HyundaiDoor extends Door {

    @Override
    protected void doClose() {
        System.out.println("Close Hyundai Door");
    }

    @Override
    protected void doOpen() {
        System.out.println("Open Hyundai Door");
    }
}


abstract class Motor {
    private MotorStatus motorStatus;
    protected Door door;

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();
        if(motorStatus == MotorStatus.MOVING) return;

        DoorStatus doorStatus = door.getDoorStatus();
        if(doorStatus == DoorStatus.OPENED) door.close();

        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }
    protected abstract void moveMotor(Direction direction);

}

class HyundaiMotor extends Motor {

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Hyundai Motor setup");
    }
}

class LGMotor extends Motor {

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("LG Motor setup");

    }

}


abstract class ElevatorFactory { // 추상 부품을 생성하는 추상 팩토리
    public abstract Motor createMotor();
    public abstract Door createDoor();
}

//LG 부품을 생성하는 팩토리
class LGElevatorFactory extends ElevatorFactory {
    public Motor createMotor() {
        return new LGMotor();
    }
    public Door createDoor() {
        return new LGDoor();
    }
}

// 현대 부품을 생성하는 팩토리
class HyundaiElevatorFactory extends ElevatorFactory {
    public Motor createMotor() {
        return new HyundaiMotor();
    }
    public Door createDoor() {
        return new HyundaiDoor();
    }
}
