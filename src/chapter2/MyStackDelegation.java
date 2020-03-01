package chapter2;

import java.util.ArrayList;

public class MyStackDelegation<String> {
    private ArrayList<String> arlist = new ArrayList<String>();
    public void push(String element) {
        arlist.add(element);
    }
    public String pop() {
        return arlist.remove(arlist.size() -1);
    }
    public boolean isEmtpy() {
        return  arlist.isEmpty();
    }
    public int size() {
        return  arlist.size();
    }

}


class Main {
    public static void main(String[] args) {

        MyStackDelegation<String> myStack = new MyStackDelegation<>();

        myStack.push("value1");
        myStack.push("value2");
        myStack.push("value3");


    }
}