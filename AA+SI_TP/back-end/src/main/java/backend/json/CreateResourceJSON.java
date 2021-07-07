package backend.json;

import backend.dao.Users;

import java.sql.Timestamp;

public class CreateResourceJSON {
    private String title;
    private String description;
    private java.sql.Timestamp registeredAt;
    private boolean visibility;
    private int idUser;
    private String type;

    public CreateResourceJSON(String title, String description,Timestamp registeredAt,boolean visibility, int idUser, String type) {
        this.title = title;
        this.description = description;
        this.registeredAt = registeredAt;
        this.visibility = visibility;
        this.idUser = idUser;
        this.type = type;
    }

    public CreateResourceJSON() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
