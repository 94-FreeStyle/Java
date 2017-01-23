package jbw.shop.web.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.CartPayDomain;
import jbw.shop.services.user.CartPayed;

public class BuyInCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("userss");
		request.setAttribute("user", new ExecuteSQL().queryUserByName(user));
		String mon = request.getParameter("mon");
		String snum = request.getParameter("num");
		List<String> list = new ArrayList<String>();
		int num = Integer.parseInt(snum);
		if (num == 0) {
		} else {
			for (int i = 0; i < num; i++) {
				if (!request.getParameter("s" + i).equalsIgnoreCase("xxxx")) {
					list.add(request.getParameter("s" + i));
					list.add(request.getParameter("n" + i));
				} else {
				}
			}
			CartPayed cp = new CartPayed();
			List<CartPayDomain> cartdo = cp.addOrder(user, list, mon);
			String address = "&nbsp;&nbsp;地址�?"
					+ new ExecuteSQL().queryUserByName(user).getU_address()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 邮编�? "
					+ new ExecuteSQL().queryUserByName(user).getU_code()
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话�? "
					+ new ExecuteSQL().queryUserByName(user).getU_phone();

			request.setAttribute("cartss", cartdo);
			double allmoney = 0;
			// 计算AllMoney
			for (CartPayDomain cpd : cartdo) {
				allmoney = allmoney + cpd.getDmoney();
			}
			request.setAttribute("allmon", allmoney);
			request.setAttribute("oid", cp.getOid());
			request.setAttribute("address", address);
			request.getRequestDispatcher("/WEB-INF/UserJSP/CartPay.jsp")
					.forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
