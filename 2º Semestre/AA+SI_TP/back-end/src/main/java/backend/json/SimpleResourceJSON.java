package backend.json;

import backend.dao.Resources;

public class SimpleResourceJSON {
    private int idResource;
    private String title;

    public SimpleResourceJSON(Resources r) {
        this.idResource = r.getIdResource();
        this.title = r.getTitle();
    }

    public int getIdResource() {
        return idResource;
    }

    public String getTitle() {
        return title;
    }
}
