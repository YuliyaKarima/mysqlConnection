package sqlConnection;

import org.junit.Test;
import sqlConnection.JDBCFactory;

import java.sql.Connection;

import static org.junit.Assert.*;

public class JDBCFactoryTest {
    @Test
    public void getConnection() throws Exception {
        Connection connection = JDBCFactory.getConnection();
        assertNotEquals(null, connection);
    }
}