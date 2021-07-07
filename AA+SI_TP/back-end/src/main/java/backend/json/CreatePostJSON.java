package backend.json;
import java.sql.Timestamp;

public class CreatePostJSON {
    String title;
    private String body;
    private java.sql.Timestamp createdAt;
    private int idUser;
    private int idResource;

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdResource() {
        return idResource;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    public String getTitle() {
        return title;
    }

    public CreatePostJSON(String title, String body, Timestamp createdAt, int idUser, int idResource) {
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.idUser = idUser;
        this.idResource = idResource;
    }
}
