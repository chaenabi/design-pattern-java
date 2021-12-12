package personalstudy.composite;

enum _Feline {
    CAT(new _Cat()), LION(new _Lion());
    private final _Animal animal;
    _Feline(_Animal animal) {
        this.animal = animal;
    }
    public _Animal getAnimal() { return animal; }
}

interface _Animal {
    void speak();
}

class SGComposition implements _Animal {
    _Cat cat = new _Cat();
    _Lion lion = new _Lion();

    private SGComposition() {}

    @Override
    public void speak() { }
}

class _Cat implements _Animal {
    private final String animalName = "고양이";

    @Override
    public void speak() {
        System.out.println("야옹");
    }
}

class _Lion implements _Animal {
    private String animalName = "사자";

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public String getAnimalName() { return animalName; }

    @Override
    public void speak() { System.out.println("크와앙"); }
}

class Main2 {
    public static void main(String[] args) {
        _Animal cat1 = _Feline.CAT.getAnimal();
        _Animal lion1 = _Feline.LION.getAnimal();

        cat1.speak();
        lion1.speak();

        _Lion leo = (_Lion) _Feline.LION.getAnimal();

        leo.setAnimalName("레오");
        System.out.println(leo.getAnimalName());
    }
}