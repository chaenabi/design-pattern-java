package chapter14;

public class Composite {

    public static void main(String[] args) {
        // 컴퓨터의 부품으로 body, keyboard, monitor 객체를 생성함
        Body body = new Body(100, 70);
        KeyBoard keyBoard = new KeyBoard(5,2);
        Monitor monitor = new Monitor(20, 30);
        Speaker speaker = new Speaker(10, 10);

        // Computer 객체를 생성하고 부품 객체들을 설정함
        Computer computer = new Computer();
        computer.addComponent(body);
        computer.addComponent(keyBoard);
        computer.addComponent(monitor);
        computer.addComponent(speaker);

        // 컴퓨터의 가격과 전력 소비량을 구함
        int computerPrice = computer.getPrice();
        int computerPower = computer.getPower();
        System.out.println("Computer Power: " + computerPower + "W");
        System.out.println("Computer Price: " + computerPrice + "만 원");
    }
}

class KeyBoard extends ComputerDevice {
    private int price;
    private int power;

    public KeyBoard(int price, int power) {
        this.price = price;
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }
}

class Body extends ComputerDevice {
    private int price;
    private int power;

    public Body(int price, int power) {
        this.price = price;
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }
}

class Monitor extends ComputerDevice {
    private int price;
    private int power;

    public Monitor(int price, int power) {
        this.price = price;
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }
}

class Speaker extends ComputerDevice {
    private int price;
    private int power;

    public Speaker(int price, int power) {
        this.price = price;
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

}