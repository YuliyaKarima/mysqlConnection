package service;

import user.User;

import java.time.LocalDateTime;

/**
 * Class for presenting user data
 */
public class UserDTO {
    private String name;
    private LocalDateTime dateOfBirthday;
    private String login;
    private String password;
    private String email;

    public UserDTO(User user) {
        this.name = user.getName();
        this.dateOfBirthday = user.getDateOfBirthday();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

    public UserDTO(String name, LocalDateTime dateOfBirthday, String login, String password, String email) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public User getUser() {
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setDateOfBirthday(dateOfBirthday);
        user.setEmail(email);
        return user;
    }
}
