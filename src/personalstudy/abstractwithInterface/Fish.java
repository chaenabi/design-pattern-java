package personalstudy.abstractwithInterface;

public abstract class Fish implements Animal {
    protected final static String character = "반드시 물속에서 산다.";
    protected abstract void moreInfo();
}

class Shark extends Fish {
    @Override
    public void printInfo() {
        System.out.println("아기 상어는 작은 물고기들을 먹는다." + character);
        moreInfo();
    }

    @Override
    protected void moreInfo() {
        System.out.println("전류에 민감하다.");
    }
}

class GoldFish extends Fish {

    @Override
    public void printInfo() {
        System.out.print("금붕어는 채식을 주로 한다." + character);
        moreInfo();
    }

    @Override
    protected void moreInfo() {
        System.out.println("기억력이 낮은 것으로 알려져 있다. ");
    }
}
