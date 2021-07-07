package backend.json;

import backend.dao.Posts;

import java.sql.Timestamp;

public class PostJSON {
    private int idPost;

    private String title;

    public String getTitle() {
        return title;
    }

    private String body;

    private java.sql.Timestamp createdAt;

    private UserJSON user;

    private ResourceSimpleJSON resource;

    private CommentJSON[] comments;

    public CommentJSON[] getComments() {
        return comments;
    }

    public ResourceSimpleJSON getResource() {
        return resource;
    }

    public int getIdPost() {
        return idPost;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public UserJSON getUser() {
        return user;
    }

    //private Resources idResource;
    public PostJSON(Posts p, CommentJSON[] cs) {
        this.idPost = p.getIdPost();
        this.title = p.getTitle();
        this.body = p.getBody();
        this.createdAt = p.getCreatedAt();
        this.user = new UserJSON(p.getIdUser());
        this.resource = new ResourceSimpleJSON(p.getIdResource());
        this.comments = cs;
    }
}
