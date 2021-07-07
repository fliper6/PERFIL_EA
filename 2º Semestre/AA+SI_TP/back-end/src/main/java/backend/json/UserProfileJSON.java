package backend.json;

public class UserProfileJSON {
    private String name;
    private String description;
    private String type;
    private String affiliation;

    public UserProfileJSON(String name, String description, String type, String affiliation) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.affiliation = affiliation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getAffiliation() {
        return affiliation;
    }
}
