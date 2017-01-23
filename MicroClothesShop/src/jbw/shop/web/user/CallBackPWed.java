package jbw.shop.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.AllDomain;
import jbw.shop.utils.MD5PW;

public class CallBackPWed extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pw = request.getParameter("pw");
		String repw = request.getParameter("repw");
		pw = MD5PW.strToMD5(pw);
		if (!((pw.equals(null) && pw.equals("")) && (repw.equals(null) && repw
				.equals("")))) {
			try {
				new ExecuteSQL().updateUserPW(AllDomain.strDomain, pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
