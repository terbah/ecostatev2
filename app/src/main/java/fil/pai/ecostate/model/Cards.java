package fil.pai.ecostate.model;

public class Cards {
    private String desc;
    private String name;
    private String profileImageUrl;


    public Cards(String desc, String name, String profileImageUrl) {
        this.desc = desc;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getdesc() {
        return desc;
    }

    public void setdesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
