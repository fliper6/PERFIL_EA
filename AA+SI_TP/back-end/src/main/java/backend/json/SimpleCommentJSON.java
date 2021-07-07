package backend.json;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class SimpleCommentJSON {
    private String body;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdAt;

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public SimpleCommentJSON(String body, Timestamp createdAt) {
        this.body = body;
        this.createdAt = createdAt;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
