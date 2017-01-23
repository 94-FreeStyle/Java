package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartPayed extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid=request.getParameter("oid");
		String bank = request.getParameter("bank");
		String user=(String)request.getSession().getAttribute("userss");
		String url=new jbw.shop.services.user.Payed().payed(oid,user,bank);
		response.sendRedirect(url);
		response.getWriter().write("<p style=\"font-size:39px;color:#ff0000;margin-top:220px;margin-left:550px\">支付成功�?</p>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
