package backend.json;

import java.sql.Timestamp;

public class UpdateResourceJSON {
    private int idResource;
    private String title;
    private String description;
    private java.sql.Timestamp registeredAt;
    private boolean visibility;
    private int idUser;
    private String type;
    private int[] delete;

    public UpdateResourceJSON() {
    }

    public UpdateResourceJSON(int idResource, String title, String description, Timestamp registeredAt, boolean visibility, int idUser, String type, int[] delete) {
        this.idResource = idResource;
        this.title = title;
        this.description = description;
        this.registeredAt = registeredAt;
        this.visibility = visibility;
        this.idUser = idUser;
        this.type = type;
        this.delete = delete;
    }

    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
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

    public int[] getDelete() {
        return delete;
    }

    public void setDelete(int[] delete) {
        this.delete = delete;
    }
}
