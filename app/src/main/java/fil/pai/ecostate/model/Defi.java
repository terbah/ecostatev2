package fil.pai.ecostate.model;

public class Defi {

    private String title;
    private int drawable;
    private int player;
    private String message;
    private int maxPlayer;
    private String reward;
    private String single_word_title;

    public Defi(String title, int drawable, int player, String message, int maxPlayer, String reward, String single_word_title) {
        this.title = title;
        this.drawable = drawable;
        this.player = player;
        this.message = message;
        this.maxPlayer = maxPlayer;
        this.reward = reward;
        this.single_word_title = single_word_title;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getSingle_word_title() {
        return single_word_title;
    }

    public void setSingle_word_title(String single_word_title) {
        this.single_word_title = single_word_title;
    }
}
