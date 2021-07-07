package backend.json;

import backend.dao.Updates;

import java.sql.Timestamp;


public class UpdateJSON {
    private int idUpdate;
    private String state;
    private java.sql.Timestamp createdAt;
    private SimpleResourceJSON resource;

    public UpdateJSON(Updates up) {
        this.idUpdate = up.getIdUpdate();
        this.state = up.getState();
        this.createdAt = up.getCreatedAt();
        this.resource = new SimpleResourceJSON(up.getIdResource());
    }

    public int getIdUpdate() {
        return idUpdate;
    }

    public String getState() {
        return state;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public SimpleResourceJSON getResource() {
        return resource;
    }
}
