package chapter6;


// 스테이트 패턴.
class Book {

    private State state;
    public Book() {
        state = new Rent();
    }

    // 스트래티지 패턴과 다른점:
    // 스트래티지: 아래와 같이 Book을 생성할때 State 인터페이스도 같이 필요하다.
    /*
        public Book(State state) {
            this.state = state;
        }
     */

}


interface State {
    void isRented();
    void isReserved();
    void isReturned();
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
