package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Admin;
import jbw.shop.domain.Order;
import jbw.shop.domain.TuiOrder;

public class TuiOperate extends HttpServlet {

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
		ExecuteSQL esql = new ExecuteSQL();
		String oid = request.getParameter("oid");
		String aname = (String) request.getSession().getAttribute("adminn");
		Order order = null;
		try {
			order = esql.getOrderById(oid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (order.getO_statu() == 0) {
			response.getWriter().write("此订单还未付款！");
		} else if (order.getO_statu() == 1) {
			response.getWriter().write("此订单还未发货！");
		} else if (order.getO_statu() == 2) {
			response.getWriter().write("此订单还未确认收货！");
		} else if (order.getO_statu() == 3) {
			try {
				Admin admin = esql.queryAdminByName(aname);
				TuiOrder to = esql.getTuiOrder(oid);
				to.setA_id(admin.getA_id());
				to.setO_id(oid);
				to.setT_odate(new Date());
				esql.updateTuiHuo(to);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			order.setO_statu(4);
			esql.updateOrderStatu(order);
			response.getWriter().write("�?货成功！");
		} else if (order.getO_statu() == 4) {
			response.getWriter().write("此订单已处理�?");
		} else {
			response.getWriter().write("处理失败�?");
		}

	}
}
