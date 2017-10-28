package user;

import java.time.LocalDateTime;

/**
 * Encapsulates user's data
 */
public class User {
    private String name;
    private LocalDateTime dateOfBirthday;
    private String login;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
