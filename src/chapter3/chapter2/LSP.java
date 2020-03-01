package chapter3.chapter2;

public class LSP {
}


class Bag {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class DisCountedBag extends Bag {
    private double discountedRate = 0;

    @Override
    public void setPrice(int price) {   // 이렇게 하지 말것
        super.setPrice(price - (int)(discountedRate * price));
    }

    public void applyDiscount(int price) { // 이렇게 할 것
        super.setPrice(price - (int)(discountedRate * price));
    }
}

class Main {
    public static void main(String[] args) {

            DisCountedBag db = new DisCountedBag();
            db.applyDiscount(1);
    }
}