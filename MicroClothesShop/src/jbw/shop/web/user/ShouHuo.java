package jbw.shop.web.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Order;

public class ShouHuo extends HttpServlet {

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
		String oid = request.getParameter("oid");
		ExecuteSQL esql = new ExecuteSQL();
		try {
			Order order = esql.getOrderById(oid);
			order.setO_qdate(new Date());
			esql.updateOrderShouTime(order);
			int statu = order.getO_statu();
			if (statu == 3) {
				response.getWriter().write("此份订单曾经已确认收货！");
			} else if (statu == 2) {
				order.setO_statu(3);
				esql.updateOrderStatu(order);
				response.getWriter().write("订单确认收货成功�?");
			} else if (statu == 1) {
				response.getWriter().write("订单还未发货，请等待发货�?");
			} else if (statu == 0) {
				response.getWriter().write("此份订单还未付款�?");
			} else {

				response.getWriter().write("确认收货失败�?");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
