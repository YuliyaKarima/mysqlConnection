import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class UserDAOTest {
    private UserDAO userDAO = new UserDAO();

    @Test
    public void getUser() throws Exception {
        User userExpected = new User();
        userExpected.setName("James");
        userExpected.setDateOfBirthday(LocalDateTime.of(1978, 03, 13, 0, 0));
        userExpected.setLogin("james");
        User userActual = userDAO.getUser(1);
        assertEquals("test failed", userExpected, userActual);
    }

    @Test
    public void updateUserName() throws Exception {
        //given
        String expectedNewName = "Bill";
        String actualNewName = null;
        //when
        userDAO.updateUserName(5, expectedNewName);
        //then
        User updatedUser = userDAO.getUser(5);
        assertEquals("test failed", expectedNewName, updatedUser.getName());
    }

    @Test(expected = Exception.class)
    public void deleteUserById() throws Exception {
        //given
        //when
        userDAO.deleteUserByID(10);
        //then
        userDAO.getUser(10);
    }

    @Test
    public void insertUser() throws Exception {
        //given
        User newUser = new User();
        newUser.setName("Anna");
        newUser.setDateOfBirthday(LocalDateTime.of(1994, 07, 8, 0, 0));
        newUser.setLogin("anna");
        //when
        userDAO.insertUser(newUser);
        //then
        User userExpected = userDAO.getUser(16);
        assertEquals("test failed", userExpected, newUser);
    }
}