package backend.json;

import java.sql.Timestamp;

public class CreateUpdateJSON {
    private String state;
    private java.sql.Timestamp createdAt;
    private int idResource;
    private int idUser;

    public CreateUpdateJSON(String state, Timestamp createdAt, int idResource, int idUser) {
        this.state = state;
        this.createdAt = createdAt;
        this.idResource = idResource;
        this.idUser = idUser;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getState() {
        return state;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getIdResource() {
        return idResource;
    }

    public int getIdUser() {
        return idUser;
    }
}
