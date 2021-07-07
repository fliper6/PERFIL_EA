package backend.json;

import backend.dao.Users;

import java.sql.Timestamp;

public class UserJSON {
    private int idUser;

    private String name;

    //private String email;

    //private String password;

    private String level;

    private java.sql.Timestamp registerDate;

    private String description;

    private String picture;

    private boolean blocked;

    private RoleJSON role;

    public int getIdUser() {
        return idUser;
    }

    //public String getEmail() {
    //    return email;
    //}

    //public String getPassword() {
    //    return password;
    //}

    public String getLevel() {
        return level;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public RoleJSON getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public UserJSON(Users u) {
        this.idUser = u.getIdUser();
        this.name = u.getName();
        //this.email = u.getEmail();
        //this.password = u.getPassword();
        this.level = u.getLevel();
        this.registerDate = u.getRegisterDate();
        this.description = u.getDescription();
        this.picture = u.getPicture();
        this.blocked = u.getBlocked();
        this.role = new RoleJSON(u.getIdRole());
    }
}
