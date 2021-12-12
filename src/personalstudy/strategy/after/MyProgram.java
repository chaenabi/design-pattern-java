package personalstudy.strategy.after;

public class MyProgram {
    public void testProgram() {
        SearchButton searchButton = new SearchButton(this);
        searchButton.onClick();
        searchButton.setSearchStrategy(new SearchStrategyMap());
        searchButton.onClick();
    }
}
