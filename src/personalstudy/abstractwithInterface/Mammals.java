package personalstudy.abstractwithInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Mammals implements Animal {

    protected MammalFamily mammals = MammalFamily.UNKNOWN;
    protected MammalEnumList species;

    public void setSpecies(MammalEnumList species) {
        MammalFamily family = mammals.findBySpecies(species);
        if(family.includes(species)) {
            mammals = family;
            this.species = species;
        } else {
            throw new CannotFoundAnimalSpecies("아직 등록되지 않은 동물입니다.");
        }
    }
    protected abstract void printTraits();
}

abstract class Primates extends Mammals {
    protected final static String character = "영장류";
    protected abstract void useHand();
}

abstract class Rodent extends Mammals {
    protected final static String character = "설치류";
    protected abstract void useTeeth();
}

class Human extends Primates {
    @Override
    protected void printTraits() {
        System.out.print("결과: " + species.getSpecies() + "는 " + mammals.getFamilyName() +"이며, " + character + "입니다. ");
    }

    @Override
    public void printInfo() {
        printTraits();
        useHand();
    }

    @Override
    protected void useHand() {
        System.out.println("손을 사용하여 도구를 씁니다.");
    }
}

class Rat extends Rodent {

    @Override
    public void printInfo() {
        printTraits();
        useTeeth();
    }

    @Override
    protected void printTraits() {
        System.out.print("결과: " + species.getSpecies() + "는 " + mammals.getFamilyName() +"이며, " + character + "입니다. ");
    }

    @Override
    protected void useTeeth() {
        System.out.println("치아로 무언가를 갉아먹습니다.");
    }
}

interface MammalEnumList {
    String getSpecies();
}

enum Ape implements MammalEnumList {
    HUMAN("인간"), CHIMPANZEE("침팬지"), GORILLA("고릴라");
    private final String species;
    Ape(String species) { this.species = species; }
    public String getSpecies() {
        return species;
    }
}

enum Murine implements MammalEnumList {
    MOUSE("생쥐"), SQUIRREL("다람쥐"), HAMSTER("햄스터"), GUINEA_PIG("기니피그");
    private final String species;
    Murine(String species) { this.species = species; }
    public String getSpecies() {
        return species;
    }
}

enum MammalFamily {
    HUMAN("인류", List.of(Ape.HUMAN, Ape.CHIMPANZEE, Ape.GORILLA)),
    RAT("쥐과", List.of(Murine.MOUSE, Murine.SQUIRREL, Murine.HAMSTER, Murine.GUINEA_PIG)),
    UNKNOWN("괴물", Collections.EMPTY_LIST);

    private final String familyName;
    private final List<MammalEnumList> animalSpeciesList;
    MammalFamily(String familyName, List<MammalEnumList> animalSpeciesList) {
        this.familyName = familyName;
        this.animalSpeciesList = animalSpeciesList;
    }

    MammalFamily findBySpecies(MammalEnumList species) {
        return Arrays.stream(MammalFamily.values())
                     .filter(family -> family.includes(species))
                     .findAny()
                     .orElse(UNKNOWN);
    }

    boolean includes(MammalEnumList species) {
        return animalSpeciesList.stream()
                                .anyMatch(species::equals);
    }

    String getFamilyName() { return familyName; }
}

class CannotFoundAnimalSpecies extends RuntimeException {
    public CannotFoundAnimalSpecies(String msg) {
        super(msg);
    }
}