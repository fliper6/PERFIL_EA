package backend.json;

import backend.dao.Comments;
import java.sql.Timestamp;

public class CommentJSON {
    private int idComment;

    private String body;

    private java.sql.Timestamp createdAt;

    private UserJSON idUser;

    public int getIdComment() {
        return idComment;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public UserJSON getIdUser() {
        return idUser;
    }

    public CommentJSON(Comments c) {
        this.body = c.getBody();
        this.createdAt = c.getCreatedAt();
        this.idComment = c.getIdComment();
        this.idUser = new UserJSON(c.getIdUser());
    }
}
