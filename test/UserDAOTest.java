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
    private Connection connection = JDBCFactory.getConnection();
    private PreparedStatement statement;

    @Before
    public void init() {
        PreparedStatement statement;
    }

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
        userDAO.updateUserName(2, expectedNewName);
        //then
        try {
            statement = connection.prepareStatement("SELECT * FROM new_schema.user where iduser = 2");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                actualNewName = rs.getString(2);
            }
        } catch (SQLException e) {

        }
        assertEquals("test failed", expectedNewName, actualNewName);
    }

    @Test
    public void deleteUserById() throws Exception {
        //given
        int expectedSize = 10;
        int actualSize = 0;
        //when
        userDAO.deleteUserByID(7);
        //then
        try {
            statement = connection.prepareStatement("SELECT * FROM new_schema.user");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                actualSize++;
            }
        } catch (SQLException e) {

        }
        assertEquals("test failed", expectedSize, actualSize);
    }

    @Test
    public void insertUser() throws Exception {
        //given
        int expectedSize = 11;
        int actualSize = 0;
        User userExpected = new User();
        userExpected.setName("Dave");
        userExpected.setDateOfBirthday(LocalDateTime.of(1978, 03, 13, 0, 0));
        userExpected.setLogin("dave");
        //when
        userDAO.insertUser(userExpected);
        //then
        try {
            statement = connection.prepareStatement("SELECT * FROM new_schema.user");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                actualSize++;
            }
        } catch (SQLException e) {

        }
        assertEquals("test failed", expectedSize, actualSize);
    }
}