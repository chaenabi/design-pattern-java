package personalstudy.abstractwithInterface;

public class AnimalDictionary {

    private Animal animalInfo;

    public void wantToKnowAbout(Animal animalInfo) {
        this.animalInfo = animalInfo;
    }

    public void onSearch() {
        animalInfo.printInfo();
    }
}
