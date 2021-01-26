package fil.pai.ecostate.model;

public class News {
    private String title;
    private Integer cover;
    private String caption;

    public News(String title, Integer cover, String caption) {
        this.title = title;
        this.caption = caption;
        this.cover = cover;
    }

    public String getCaption() {
        return caption;
    }

    public String getTitle() {
        return title;
    }

    public Integer getCover() {
        return cover;
    }
}
