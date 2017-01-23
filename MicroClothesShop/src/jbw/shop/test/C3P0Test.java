package jbw.shop.test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jbw.shop.domain.User;
import jbw.shop.utils.C3P0JDBCUtil;
import jbw.shop.utils.MapBeanMapping;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
	@Test
	// 代码配置连接测试
	public void test1() throws PropertyVetoException, SQLException {
		// 生成c3p0数据库连接池对象
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		// 基本配置
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/goods");
		cpds.setUser("root");
		cpds.setPassword("jbw994730");
		// 池配�?
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);// 设置增量
		cpds.setMaxPoolSize(20);
		// 创建连接对象
		Connection connection = cpds.getConnection();
		System.out.println(connection.getClass().getName());
		// 关闭连接�?
		cpds.close();
	}

	@Test
	// .xml配置文件配置连接测试
	public void test2() throws SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		Connection connection = cpds.getConnection();
		System.out.println(connection.getClass().getName());
		// 关闭连接�?
		cpds.close();
	}

	// .xml配置文件配置连接测试
	@Test
	public void test4() throws SQLException {
		Connection connection = C3P0JDBCUtil.getConnection();
		System.out.println(connection.getClass().getName());
	}

	@Test
	public void test3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 123);
		map.put("name", "kevin");
		map.put("age", 21);

		User user = MapBeanMapping.toBean(map, User.class);

		System.out.println(user);
	}
}
