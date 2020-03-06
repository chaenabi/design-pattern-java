package chapter8;

public class CommandPattern {
    Command command;
    CommandPattern(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void ado() {
        command.execute();
    }
}

interface Command {
    public void execute();

}

class TurnClass implements Command {
    Turn turn;
    @Override
    public void execute() {
        turn.turnOn();
    }
}

class FlagClass implements Command {

    @Override
    public void execute() {

    }

}

class Turn {
    public void turnOn() {

    }
    public void turnOff() {

    }
}
