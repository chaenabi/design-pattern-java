package personalstudy.composite;

// instead of inheritance, use composite pattern.
interface Animal<T> {}

abstract class Feline<T extends Feline<T>> implements Animal<T> {
    abstract void speak();
}

//abstract class Canine<T extends Canine<T>> implements Animal<T> {} // if it would be needed later..

class Cat extends Feline<Cat> implements Animal<Cat>  {

    private final String animalName = "고양이";

    public String getName() {
        return animalName;
    } // cannot find this method in Feline class (the parent of Cat) definitely.

    @Override
    public void speak() {
        System.out.println("야옹");
    }
}

class Lion extends Feline<Lion> implements Animal<Lion>  {

    private String animalName = "사자";

    public String getAnimalName() {
        return animalName;
    }
    public Lion() {}
    public Lion(String name) {
        this.animalName = name;
    }

    @Override
    public void speak() {
        System.out.println("크와앙");
    }
}

@SuppressWarnings("rawtypes")
public enum SGBuilder implements Animal<Feline> {
    CAT(new Cat()), LION(new Lion()), LION_ARGUMENT(new Lion("심바"));

    private final Feline sigleTonObj;
    private SGBuilder(Feline single) {
        this.sigleTonObj = single;
    }

    public Feline getSingleTon() {
        return sigleTonObj;
    }
}
/*class MainTest {

    public static void main(String[] args) {
        Feline cat = SGBuilder.CAT.getSingleTon();
        Feline<Lion> lion = SGBuilder.LION.getSingleTon();

        cat.speak();
        lion.speak();

        Cat cat2 = (Cat) SGBuilder.CAT.getSingleTon();
        Lion lion2 = (Lion) SGBuilder.LION.getSingleTon();

        System.out.println("cat   : " + cat);
        System.out.println("cat2  : " + cat2);
        System.out.println("lion : " + lion);

        cat2.speak();
        lion2.speak();

        //System.out.println(cat.getName());  // cannot access this without downCasting, so this command makes compile error.
                                            // of course it can be found if getName() move into Feline abstract class -
                                            // but if there are some of the variable or method Cat Class only needs?
        System.out.println(cat2.getName()); // can access.
        System.out.println("cat == cat2      ? " + (cat == cat2));
        System.out.println("cat.equals(cat2) ? " + (cat.equals(cat2)));

        Lion simba = (Lion) SGBuilder.LION_ARGUMENT.getSingleTon();
        System.out.println(simba.getAnimalName());
    }
}*/
/*
@Getter
class Dog extends Canine implements Animal<Canine> {
    private final String name = "멍멍이";
    @Override
    public void speak() { System.out.println("멍멍"); }
}*/
