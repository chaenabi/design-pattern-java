package personalstudy.strategy.before;

public enum Mode {
    ALL("전체 검색"), IMAGES("이미지 검색"), NEWS("뉴스 검색"), MAP("지도 검색");

    private final String title;
    Mode(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }


}
