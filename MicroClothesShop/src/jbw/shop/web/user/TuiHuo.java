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
import jbw.shop.domain.TuiOrder;
import jbw.shop.utils.ByteID;

public class TuiHuo extends HttpServlet {

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
		Order order = null;
		try {
			order = esql.getOrderById(oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int statu = order.getO_statu();
		if (statu == 3) {
			TuiOrder to = new TuiOrder();
			to.setO_id(oid);
			to.setT_date(new Date());
			to.setT_id(ByteID.uuid());
			to.setT_reson("不想买了");
			to.setA_id("101");
			to.setT_odate(new Date());
			to.setU_id(order.getU_id());
			to.setO_money(order.getO_money());
			esql.addTuiHuoRecord(to);
			response.getWriter().write("已提交�??货申请！");
		} else if (statu == 2) {
			response.getWriter().write("您还没确认收货！");
		} else if (statu == 1) {
			response.getWriter().write("订单还未发货�?");
		} else if (statu == 0) {
			response.getWriter().write("您还未为此订单付款！");
		} else {
			response.getWriter().write("�?货失败！");
		}
	}

}
