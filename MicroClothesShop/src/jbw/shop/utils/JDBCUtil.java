package jbw.shop.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;



public final class JDBCUtil {
	private JDBCUtil() {
	}

	// MYSQL
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/goods";
	private static String username = "root";
	private static String password = "jbw994730";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return (Connection) DriverManager
				.getConnection(url, username, password);
	}

	public static void free(ResultSet rs, java.sql.Statement sta,
			java.sql.Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// Oracle
	String odirver = "oracle.jdbc.OracleDriver";
	String oracleurl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";// thin 表示连接方式

}
