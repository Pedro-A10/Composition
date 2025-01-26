package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date birthDate;
    private String name;
    private String email;


    public Client( String name, String email, Date birthDate) {
        this.birthDate = birthDate;
        this.name = name;
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + sdf.format(birthDate) + ") - " + email;
    }
}
