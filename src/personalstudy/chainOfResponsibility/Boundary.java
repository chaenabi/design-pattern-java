package personalstudy.chainOfResponsibility;

public abstract class Boundary {

    protected int upper;
    protected int lower;

    protected Boundary nested;
    public void setNested(Boundary nested) {
        this.nested = nested;
    }

    protected Boundary(int upper, int lower) {
        this.upper = upper;
        this.lower = lower;
    }

    public void action(int value) {
        if(isInBoundary(value)) individualAction();
        else if(nested != null) nested.action(value);
        else individualAction();
    }

    private boolean isInBoundary(int value) {
        return value >= lower && value <= upper;
    }

    abstract protected void individualAction();
}


class NormalVoltage extends Boundary {

    public NormalVoltage(int upper, int lower) { super(upper, lower); }

    @Override
    protected void individualAction() {
        System.out.println("normal operation");
    }
}

class WarningVoltage extends Boundary {

    public WarningVoltage(int upper, int lower) {
        super(upper, lower);
    }

    @Override
    protected void individualAction() {
        System.out.println("warning operation");
    }
}

class FaultVoltage extends Boundary {


    public FaultVoltage(int upper, int lower) {
        super(upper, lower);
    }

    @Override
    protected void individualAction() {
        System.out.println("fault operation");
    }
}


class Main {
    public static void main(String[] args) {
        Boundary voltage = new NormalVoltage(230, 210);
        Boundary warning = new WarningVoltage(240, 200);
        Boundary fault = new FaultVoltage(365, 300);

        voltage.setNested(warning);
        warning.setNested(fault);


        voltage.action(220);
        voltage.action(235);
        voltage.action(305);

    }
}