package fil.pai.ecostate.model;

public class AstucesModel {
    private String texte;
    private int src;
    private String title;

    public AstucesModel(String texte, int src, String title){
        this.texte = texte;
        this.src = src;
        this.title = title;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getTitle() {return title; }

    public void setTitle(String title) {this.title = title; }

}
