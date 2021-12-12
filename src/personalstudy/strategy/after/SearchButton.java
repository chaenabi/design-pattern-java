package personalstudy.strategy.after;

public class SearchButton {
    private final MyProgram myProgram;
    public SearchButton(MyProgram myProgram) {
        this.myProgram = myProgram;
    }

    private SearchStrategy searchStrategy = new SearchStrategyAll();

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void onClick () {
        searchStrategy.search();
    }
}
