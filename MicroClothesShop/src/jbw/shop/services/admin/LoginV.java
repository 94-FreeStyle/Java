package jbw.shop.services.admin;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Admin;
import jbw.shop.domain.User;

public class LoginV {
	// 验证管理员登�?
	public boolean VALogin(String name, String pw) {
		ExecuteSQL exesql = new ExecuteSQL();
		boolean flg = exesql.isExitsAdmin(name);
		if (flg) {
			return false;
		} else {
			Admin admin = exesql.queryAdminByName(name);

			if ((name.equalsIgnoreCase(admin.getA_name()))
					&& (pw.equals(admin.getA_pw()))) {
				exesql.updateAdminLoginTime(name);
				return true;
			} else {
				return false;
			}
		}
	}

	// 验证普�?�用户登�?
	public boolean VULogin(String name, String pw) {
		ExecuteSQL exesql = new ExecuteSQL();
		boolean flag = exesql.isExist(name);
		if (flag) {
			return false;
		} else {
			User user = exesql.queryUserByName(name);
			if ((name.equalsIgnoreCase(user.getU_name()))
					&& (pw.equals(user.getU_pw()))) {
				return true;
			} else {
				return false;
			}
		}
	}

}
