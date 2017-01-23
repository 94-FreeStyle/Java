package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.services.user.AddCartServices;

public class AddCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String num = request.getParameter("cnum");
		int nums = Integer.parseInt(num);
		String packages = request.getParameter("package");
		String user = (String) request.getSession().getAttribute("userss");
		new AddCartServices().addCart(cid, nums, packages, user);
	}

}
