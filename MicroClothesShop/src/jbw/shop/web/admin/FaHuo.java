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

public class FaHuo extends HttpServlet {

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
		String aname=(String)request.getSession().getAttribute("adminn");
		
		String oid = request.getParameter("oid");
		ExecuteSQL ex = new ExecuteSQL();
		Admin admin=ex.queryAdminByName(aname);
		try {
			Order order = ex.getOrderById(oid);
			if (order.getO_statu() == 1) {
				order.setO_statu(2);
				ex.updateOrderStatu(order);
				response.getWriter().write("已发�?");
				order.setO_fdate(new Date());
				ex.updateOrderFaTime(order);
				ex.updateFaHouAdmin(admin.getA_id(), oid);
			} else if (order.getO_statu() == 0) {
				response.getWriter().write("您所选的订单还未支付�?");
			} else if (order.getO_statu() == 3) {
				response.getWriter().write("您所选的订单已发货！");
			} else if (order.getO_statu() == 4) {
				response.getWriter().write("您所选的订单已收货！");
			} else {
				response.getWriter().write("发货出现错误�?");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
