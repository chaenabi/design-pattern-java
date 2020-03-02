package chapter4;

public class Diagram { }

class who {
    private static A1 a1 = new A1();

    public static void main(String[] args) {
        System.out.println(a1.doA1());
    }

}

class A1 {
    private static A3 a3 = new A3();
    public int doA1() {

        A2 a2 = new A2();
        a2.doA2(this);
        a3.doIt();
        return 1;
    }

}

class A2 {
    public int doA2(A1 a1) {
        A3 a3 = new A3();
        doIt(a3);
        return 1;
    }
    public int doIt(A3 a3) {

        return 5;
    }


}

class A3 {
    public int doIt() {
        return 6;
    }
}