package personalstudy.abstractwithInterface;

public class MainClient {
    public static void main(String[] args) {
        AnimalDictionary dictionary = new AnimalDictionary();

        Mammals mammals = new Human();
        MammalEnumList mammalList = Ape.CHIMPANZEE;
        dictionary.wantToKnowAbout(mammals);
        mammals.setSpecies(mammalList);
        dictionary.onSearch();

        mammals = new Rat();
        mammalList = Murine.GUINEA_PIG;
        dictionary.wantToKnowAbout(mammals);
        mammals.setSpecies(mammalList);
        dictionary.onSearch();

        Fish fish = new GoldFish();
        dictionary.wantToKnowAbout(fish);
        dictionary.onSearch();

    }
}
