package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.services.user.PageDisplay;

public class MainRightDisplay extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageCode = 1;
		String s = request.getParameter("pageCode");

		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		}
		request.setAttribute("pb", new PageDisplay().queryByPage(pageCode));
		request.getRequestDispatcher("/WEB-INF/UserJSP/UserMain_Right.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
