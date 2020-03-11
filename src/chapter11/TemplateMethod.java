package chapter11;

public class TemplateMethod {

    public static void main(String[] args) {
        Door door = new Door();
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.UP);
    }

}

enum Direction {
    UP, DOWN
}
enum MotorStatus {
    MOVING, STOPPED
}
enum DoorStatus {
    OPENED, CLOSED
}

class Door {
    private DoorStatus doorStatus;

    public Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void open() {
        doorStatus = DoorStatus.OPENED;
    }

    public void close() {
        doorStatus = DoorStatus.CLOSED;
    }
}

abstract class Motor {
    protected Door door;
    private MotorStatus motorStatus;

    public Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
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

    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("현대 모터 구동");
    }
}

class LGMotor extends Motor {

    public LGMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("엘지 모터 구동");

    }

}
