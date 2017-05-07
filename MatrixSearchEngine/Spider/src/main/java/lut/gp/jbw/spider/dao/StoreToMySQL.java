package lut.gp.jbw.spider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vincent May 1, 2017 4:34:04 PM
 */
public class StoreToMySQL {

    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    public static void storeURL(String url, String localPath) {
        try {
            sql = "insert into page_url(url, local_path) values(?,?)";
            PreparedStatement sta = conn.prepareStatement(sql);
            sta.setString(1, url);
            sta.setString(2, localPath);
            sta.executeUpdate();
        } catch (SQLException ex) {
        }
    }
}
