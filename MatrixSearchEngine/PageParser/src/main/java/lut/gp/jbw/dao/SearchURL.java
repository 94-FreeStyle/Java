package lut.gp.jbw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import lut.gp.jbw.util.dao.ConnectionPoolManager;

/**
 *
 * @author vincent May 1, 2017 4:44:11 PM
 */
public class SearchURL {

    private static final Connection conn = ConnectionPoolManager.getInstance().getConnection();
    private static String sql = "";

    public static String serachURL(String localPath) {
        String url = "";
        try {
            sql = "select url from mse.spider where local_path='" + localPath + "'";
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                url = rs.getString("url");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchURL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }
}
