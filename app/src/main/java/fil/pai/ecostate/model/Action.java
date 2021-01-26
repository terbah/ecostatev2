package fil.pai.ecostate.model;

public class Action {

    private String texte;
    private boolean checked;

    public Action(String texte) {
        this.texte = texte;
        this.checked = false;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
