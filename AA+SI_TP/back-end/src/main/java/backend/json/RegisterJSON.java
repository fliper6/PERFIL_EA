package backend.json;

import java.sql.Timestamp;
import java.util.Date;

public class RegisterJSON {
    private String name;
    private String email;
    private String password;
    private java.sql.Timestamp registerDate;
    private String description;
    private String type;
    private String affiliation;

    public RegisterJSON(String name, String email, String password, java.sql.Timestamp registerDate, String description, String type, String affiliation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
        this.description = description;
        this.type = type;
        this.affiliation = affiliation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegisterDate(java.sql.Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public java.sql.Timestamp getRegisterDate() {
        return registerDate;
    }

    public String getDescription() {
        return description;
    }

}
