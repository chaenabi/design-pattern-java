package personalstudy.proxy;

public interface Thumnail {

    void showTitle();
    void showPreview();
}

class RealThumbnail implements  Thumnail {

    private final String title;
    private String movieUrl;

    public RealThumbnail(String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;

        System.out.println(movieUrl + "로 부터 " + title +"의 영상 데이터 다운");
    }


    @Override
    public void showTitle() {
        System.out.println("제목: " + title);
    }

    @Override
    public void showPreview() {
        System.out.println(title + "의 프리뷰 재생");
    }
}

class ProxyThumnail implements Thumnail {

    private String title;
    private String movieUrl;

    private RealThumbnail realThumbnail;

    public ProxyThumnail(String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;
    }

    @Override
    public void showTitle() {
        System.out.println("제목: " + title);
    }

    @Override
    public void showPreview() {
        if(realThumbnail == null) realThumbnail = new RealThumbnail(title, movieUrl);
        realThumbnail.showPreview();
    }
}
