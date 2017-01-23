package jbw.shop.services.user;

import java.sql.SQLException;

import jbw.shop.dao.ExecuteSQL;

public class AddCartServices {
	public void addCart(String id, int num, String packages, String user) {
		ExecuteSQL qsql = new ExecuteSQL();
		long flg = qsql.isExistClo(id);
		//flg为true表示没有
		if (flg==0) {
			try {
				qsql.addCart(id, num, packages, user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {			
				num=num+qsql.getCUMById(id).getC_num();
				qsql.updateCart(id, num);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
