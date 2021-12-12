package personalstudy.strategy.before;

public class MyProgram {

    private SearchButton searchButton = new SearchButton(this);

    public Mode mode = Mode.ALL;

    public void setModeAll () { mode = Mode.ALL; }
    public void setModeImages () { mode = Mode.IMAGES; }
    public void setModeNews () { mode = Mode.NEWS; }
    public void setModeMap () { mode = Mode.MAP; }
}
