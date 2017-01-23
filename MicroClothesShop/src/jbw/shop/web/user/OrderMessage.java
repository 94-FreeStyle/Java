package jbw.shop.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;

public class OrderMessage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");
		jbw.shop.services.admin.OrderMessage om = new jbw.shop.services.admin.OrderMessage();
		request.setAttribute("cloth", om.getOrederMess(oid));
		request.setAttribute("nums", om.getNum());

		try {
			request.setAttribute("order", new ExecuteSQL().getOrderById(oid));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/UserJSP/OrderMessTemplates.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}