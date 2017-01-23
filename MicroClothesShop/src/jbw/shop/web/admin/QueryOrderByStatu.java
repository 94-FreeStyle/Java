package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Order;

public class QueryOrderByStatu extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String statu = request.getParameter("statu");
		int sta = Integer.parseInt(statu);
		List<Order> list = null;
		ExecuteSQL esql = new ExecuteSQL();
		try {
			list = esql.getOrderByStatu(sta);
			request.setAttribute("onum", esql.getOrderCount());
			request.setAttribute("fnum", esql.getFaOrderCount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("orderes", list);
		request.getRequestDispatcher("/WEB-INF/AdminJSP/AMR_QueryAllOrder.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
