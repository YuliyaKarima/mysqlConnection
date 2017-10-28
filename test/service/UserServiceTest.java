package service;

import dataAccessLevel.UserDAO;
import exception.IncorrectPasswordException;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import user.User;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService service;
    UserDAO userDAO;

    @Before
    public void init() {
        userDAO = new UserDAO();
        service = new UserService(userDAO);
    }

    @Test
    public void sighUpNewUser() throws Exception {
        //given
        UserDTO dto = new UserDTO("Michael", LocalDateTime.of(1985, 10, 05, 0, 0),
                "michael", "1029384756", "michael@gmail.com");
        //when
        User user = service.sighUp(dto);
        //then
        assertEquals("test failed", UserTransformer.toUser(dto).toString(), user.toString());
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void MustThrowExceptionWhenExistingLogin() {
        //given
        UserDTO dto = new UserDTO("Michael", LocalDateTime.of(1985, 10, 05, 0, 0),
                "michael", "1029384756", "michael@gmail.com");
        //when
        User user = service.sighUp(dto);
        //then
    }

    @Test
    public void loginExistingUserRightPassword() throws Exception {
        //
        User user;
        String password = "1029384756";
        String login = "michael";
        //
        user = service.login(login, password);
        assertNotEquals(false, user != null);
        //
    }

    @Test(expected = IncorrectPasswordException.class)
    public void loginExistingUserIncorrectPassword() throws Exception {
        //
        User user;
        String password = "gfgfgfgf";
        String login = "michael";
        //
        user = service.login(login, password);
        //
    }

    @Test(expected = UserNotFoundException.class)
    public void loginUnexistingUser() throws Exception {
        //
        User user;
        String password = "gfgfgfgf";
        String login = "cherry";
        //
        user = service.login(login, password);
        //
    }



}