import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private String name;
    private LocalDateTime dateOfBirthday;
    private String login;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String toString() {
        return name + " " + dateOfBirthday + " " + login;
    }

    public boolean equals(Object o) {
        return this.toString().equals(((User) o).toString());
    }
}
