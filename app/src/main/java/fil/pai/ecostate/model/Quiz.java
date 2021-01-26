package fil.pai.ecostate.model;

public class Quiz {
    private String title;
    private String caption;

    public Quiz(String caption) {
        this.title = "Quiz du jour ! ";
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public String getTitle() {
        return title;
    }

}