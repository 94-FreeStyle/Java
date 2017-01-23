package jbw.shop.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.services.admin.LoginV;

public class AdminLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String pw;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		username = request.getParameter("username");
		pw = request.getParameter("pw");

		if (!((username == null) && username.trim().isEmpty())
				&& !(pw == null && pw.trim().isEmpty())) {
			boolean flag = new LoginV().VALogin(username, pw);
			request.getSession().setAttribute("adminn", username);
			if (flag) {
				request.getRequestDispatcher("/WEB-INF/AdminJSP/AdminMain.html")
						.forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/AdminJSP/AdminLogin.jsp")
						.forward(request, response);
			}

		} else {
			request.getRequestDispatcher("/WEB-INF/AdminJSP/AdminLogin.jsp")
					.forward(request, response);
		}

	}

}
