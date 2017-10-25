
import java.sql.*;

public class UserDAO {
    private String getQuery = "SELECT * FROM new_schema.user ";
    private String updateNameQuery = "UPDATE  new_schema.user SET name =  ";
    private String deleteQuery = "DELETE from new_schema.user";
    private String insertQuery = "INSERT INTO new_schema.user values ";
    private String whereId = " where iduser = ";
    private Connection connection = JDBCFactory.getConnection();

    /**
     * Gets user by id in DB table
     *
     * @param userId id user in DB table
     * @return User object
     */
    public User getUser(int userId) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(getQuery + whereId + userId)) {
            ResultSet rs = statement.executeQuery();
            //set after commit = false
            //Тогда в catch connection.false
            while (rs.next()) {
                user.setName(rs.getString(2));
                user.setDateOfBirthday(rs.getTimestamp(3).toLocalDateTime());
                user.setLogin(rs.getString(4));
                rs.getRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.getDateOfBirthday().getClass();
        return user;
    }

    /**
     * Changes user name by user id in DB table
     *
     * @param userId id user in DB table
     * @param name   new user name
     */
    public void updateUserName(int userId, String name) {
        String sql = updateNameQuery + "'" + name + "'" + whereId + userId;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes user from DB table by user id
     *
     * @param userId
     */
    public void deleteUserByID(int userId) {
        String sql = deleteQuery + whereId + userId;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert new user into DB table
     *
     * @param newUser User object for inserting to DB table
     */
    public void insertUser(User newUser) {
        String sql = null;
        try (Statement statement = connection.createStatement();
             PreparedStatement statementAll = connection.prepareStatement("SELECT * FROM new_schema.user")) {
            ResultSet rs = statementAll.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println(id);
            sql = insertQuery + "(" + (id + 1) + ", '" + newUser.getName() + "'"
                    + ", " + "'" + newUser.getDateOfBirthday().toLocalDate() + "'"
                    + ", " + "'" + newUser.getLogin() + "'" + ")";
            System.err.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
