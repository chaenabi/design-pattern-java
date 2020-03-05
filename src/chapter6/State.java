package chapter6;

class Book {

    private State state;

}

interface State {
    public void isRented();
    public void isReserved();
    public void isReturned();
}

class Rent implements State {

    @Override
    public void isRented() {

    }

    @Override
    public void isReserved() {

    }

    @Override
    public void isReturned() {

    }
}
