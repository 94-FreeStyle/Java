package jbw.shop.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0JDBCUtil {
	//利用c3p0-config.xml文件来指定连接信�?
	private static DataSource cpds = new ComboPooledDataSource();
	public static DataSource getDataSource(){
		return cpds;
	}
	public static Connection getConnection() throws SQLException{
		Connection connection=cpds.getConnection();
		return connection;
	}
}
