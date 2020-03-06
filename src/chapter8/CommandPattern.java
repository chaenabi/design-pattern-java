package chapter8;

// Command Pattern

class Client {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Command lampOnCommand = new LampOnCommand(lamp);

        Button lampButton = new Button(lampOnCommand); // 램프를 켜는 커맨드를 설정함
        lampButton.pressed(); // 버튼이 눌리면, 램프를 켜는 기능이 실행됨.

        Alarm alarm = new Alarm();
        Command alarmOnCommand = new AlarmOnCommand(alarm);
        Button alarmButton = new Button(alarmOnCommand);
        alarmButton.pressed(); // 버튼이 눌리면, 알람을 울리는 기능이 실행됨.

        alarmButton.setCommand(lampOnCommand); // 이 코드를 주석처리하면 버튼을 눌렀을 때마다
                                                // 알람을 울리는 기능만 계속 실행된다.
        alarmButton.pressed(); // 주석처리하지 않았으므로 램프를 켜는 기능이 실행된다.


    }
}



interface Command {
    void execute();
}

class Button {
    private Command theCommand;

    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    public void pressed() { // 버튼이 눌리면 주어진 Command의 execute 메서드를 호출함
        theCommand.execute();
    }
}

class Alarm {
    public void start() {
        System.out.println("Alarming...");
    }
}

class Lamp {
    public void turnOn() {
        System.out.println("Lamp On");
    }
}

class AlarmOnCommand implements Command { // 알람을 울리는 클래스
    private Alarm theAlarm;

    AlarmOnCommand(Alarm theAlarm) {
        this.theAlarm = theAlarm;
    }

    @Override
    public void execute() {
        theAlarm.start();
    }

}
class LampOnCommand implements Command { // 램프를 켜는 클래스
    private Lamp theLamp;

    LampOnCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    @Override
    public void execute() {
        theLamp.turnOn();
    }
}
