package backend.json;

import java.sql.Timestamp;

public class SimpleStateJSON {
    private String state;
    private java.sql.Timestamp createdAt;

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public SimpleStateJSON() {
    }
}
