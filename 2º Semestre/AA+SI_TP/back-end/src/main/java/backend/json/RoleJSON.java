package backend.json;

import backend.dao.Roles;

public class RoleJSON {
    private int idRole;
    private String type;
    private String affiliation;

    public int getIdRole() {
        return idRole;
    }

    public String getType() {
        return type;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public RoleJSON(Roles r) {
        this.idRole = r.getIdRole();
        this.type = r.getType();
        this.affiliation = r.getAffiliation();
    }
}
