
import java.sql.*;

public class UserDAO {
    private String getQuery = "SELECT * FROM new_schema.user where iduser = ? ";
    private String updateNameQuery = "UPDATE  new_schema.user SET name =  ? where iduser = ? ";
    private String deleteQuery = "DELETE from new_schema.user where iduser = ?";
    private String insertQuery = "INSERT INTO new_schema.user (`name`, `date_birthday`, `login`) values ";
    private Connection connection = JDBCFactory.getConnection();

    /**
     * Gets user by id in DB table
     *
     * @param userId id user in DB table
     * @return User object
     */
    public User getUser(int userId) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setName(rs.getString(2));
                user.setDateOfBirthday(rs.getTimestamp(3).toLocalDateTime());
                user.setLogin(rs.getString(4));
                rs.getRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return user;
    }

    /**
     * Changes user name by user id in DB table
     *
     * @param userId id user in DB table
     * @param name   new user name
     */
    public void updateUserName(int userId, String name) {
        try (PreparedStatement statement = connection.prepareStatement(updateNameQuery)) {
            statement.setString(1, name);
            statement.setInt(2, userId);
            statement.executeUpdate();
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
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
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
        try (Statement statement = connection.createStatement()) {
            sql = insertQuery + "(" + "'" + newUser.getName() + "'"
                    + ", " + "'" + newUser.getDateOfBirthday().toLocalDate() + "'"
                    + ", " + "'" + newUser.getLogin() + "'" + ")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
