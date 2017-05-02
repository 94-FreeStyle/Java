package lut.gp.jbw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lut.gp.jbw.util.dao.ConnectionPoolManager;
import org.junit.Test;

/**
 *
 * @author vincent Apr 29, 2017 9:40:19 PM
 */
public class ConnectionTest {

    @Test
    public void testConnection() throws SQLException {
        System.out.println("connection");
        Connection conn = ConnectionPoolManager.getInstance().getConnection();
        System.out.println(conn);
        String sql = "insert into test(id, name) values(?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "12");
        ps.setString(2, "vincent");
        ps.executeUpdate();
    }
}
