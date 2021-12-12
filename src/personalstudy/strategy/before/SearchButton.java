package personalstudy.strategy.before;

public class SearchButton {

    private final MyProgram myProgram;

    public SearchButton(MyProgram myProgram) {
        this.myProgram = myProgram;
    }

    public void onClick() {
        switch (myProgram.mode) {
            case ALL:
                System.out.println("SEARCH ALL");
            case IMAGES:
                System.out.println("SEARCH ALL");
            case NEWS:
                System.out.println("SEARCH ALL");
            case MAP:
                System.out.println("SEARCH ALL");

        }
    }

}
