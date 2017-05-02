package lut.gp.jbw.util.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vincent Apr 4, 2017 9:04:29 PM
 */
public final class ConnectionPoolManager {

    private static ConnectionPoolManager instance;
    private final static PoolBean beanMysql = new PoolBean();
    private static List<Connection> connList = new ArrayList<>();

    private ConnectionPoolManager() {
        beanMysql.setDriverName("com.mysql.jdbc.Driver");
        beanMysql.setUrl("jdbc:mysql://localhost:3306/mse");
        beanMysql.setUserName("root");
        beanMysql.setPassword("jbw994730");
        beanMysql.setMinConnections(5);
        beanMysql.setMaxConnections(100);
    }

    private static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName(beanMysql.getDriverName());
            conn = DriverManager.getConnection(beanMysql.getUrl(), beanMysql.getUserName(), beanMysql.getPassword());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionPoolManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static synchronized ConnectionPoolManager getInstance() {
        if (instance == null) {
            instance = new ConnectionPoolManager();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connList.size() < beanMysql.getMinConnections()) {
            int x = beanMysql.getMinConnections() - connList.size();
            for (int i = 0; i < x; i++) {
                connList.add(createConnection());
            }
        }
        Connection conn = connList.get(0);
        connList.remove(0);
        return conn;
    }

    public static boolean releaseConnection(Connection conn) {
        return connList.add(conn);
    }
}
