package chapter1;

public abstract class HomeAppliancies {

    private int serialNo;
    private String manufacturer;
    private int year;

    HomeAppliancies(int serialNo, String manufacturer, int year) {
        this.serialNo = serialNo;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    abstract void turnOn();
    abstract void turnOff();
}
class Washer extends HomeAppliancies {
    private int serialNo;
    private String manufacturer;
    private int year;
    Washer(int serialNo, String manufacturer, int year) {
        super(serialNo, manufacturer, year);
    }
    @Override
    void turnOn() {
        System.out.println("Washer turnOn() ");
    }

    @Override
    void turnOff() {
        System.out.println("Washer turnoff() ");
    }
}

class Freezer extends HomeAppliancies {

    Freezer(int serialNo, String manufacturer, int year) {
        super(serialNo, manufacturer, year);
    }

    @Override
    void turnOn() {
        System.out.println("Freezer turnOn() ");
    }

    @Override
    void turnOff() {
        System.out.println("Freezer turnoff() ");
    }
}

class DishWasher extends HomeAppliancies {
    DishWasher(int serialNo, String manufacturer, int year) {
        super(serialNo, manufacturer, year);
    }

    @Override
    void turnOn() {
        System.out.println("DishWasher turnOn() ");
    }

    @Override
    void turnOff() {
        System.out.println("DishWasher turnoff() ");
    }
}
