package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.domain.User;
import jbw.shop.services.user.UserRegister;
import jbw.shop.utils.ByteID;

public class Register extends HttpServlet {

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
		String name = request.getParameter("t_UserName");
		String address = request.getParameter("address");
		String code = request.getParameter("code");
		String sex = request.getParameter("rb_Sex");
		String pw = request.getParameter("t_UserPass");
		String repw = request.getParameter("t_RePass");
		String phone = request.getParameter("phone");
		String bank = request.getParameter("bank");
		String bankCard = request.getParameter("iptCard");
		String tax = request.getParameter("iptName");
		String email = request.getParameter("t_Email");
		String checkCode = request.getParameter("t_CheckCode");
		User user = new User(ByteID.uuid(), name, 1, pw, email, phone, code,
				tax, bank, bankCard, address, sex,0,"");
		System.out.println(name);
		String single = new UserRegister().register(user, repw, checkCode);
		if (single.equals("ok")) {
			request.getRequestDispatcher("/WEB-INF/UserJSP/Login.jsp").forward(
					request, response);
		} else if (single.equals("nosame")) {
			request.getRequestDispatcher("/WEB-INF/UserJSP/Register.jsp")
					.forward(request, response);
		} else if (single.equals("exits")) {
			request.getRequestDispatcher("/WEB-INF/UserJSP/Register.jsp")
					.forward(request, response);
		}
	}
}
