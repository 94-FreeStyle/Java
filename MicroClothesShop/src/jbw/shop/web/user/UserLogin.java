package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.AllDomain;
import jbw.shop.domain.User;
import jbw.shop.services.admin.LoginV;
import jbw.shop.utils.MD5PW;

public class UserLogin extends HttpServlet {

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
		String username = request.getParameter("username");
		String pw = MD5PW.strToMD5(request.getParameter("pw"));
		if (!(((username.trim() == null) && (username.equals("")))
				&& ((pw.trim() == null)) && (pw.equals("")))) {
			boolean flag = new LoginV().VULogin(username, pw);
			if (flag) {
				User user=new ExecuteSQL().queryUserByName(username);
				request.getSession().setAttribute("loginuu", user);
				AllDomain.intDomain=AllDomain.intDomain+1;
				request.getRequestDispatcher("/WEB-INF/UserJSP/UserMain.html")
						.forward(request, response);
				HttpSession session=request.getSession();
				session.setAttribute("userss", username);
				
			} else {
				request.getRequestDispatcher("/WEB-INF/UserJSP/Login.jsp")
						.forward(request, response);
			}

		} else {
			request.getRequestDispatcher("/WEB-INF/UserJSP/Login.jsp").forward(
					request, response);
		}
	}

}
