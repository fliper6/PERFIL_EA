package backend.json;

import backend.dao.Resources;

public class ResourceSimpleJSON {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ResourceSimpleJSON(Resources r){
        this.id = r.getIdResource();
        this.title = r.getTitle();
    }
}
