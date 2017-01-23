package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.AllDomain;
import jbw.shop.services.user.SendMail;

public class CallBackPW extends HttpServlet {

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
		String name = request.getParameter("name");
		AllDomain.strDomain=name;
		String mail = request.getParameter("mail");
		if (!(((name.trim().equals(null)) && (name.equals(""))) && ((mail
				.trim().equals(null)) && (mail.equals(""))))) {

			boolean flg = new ExecuteSQL().isExist(name);
			if (!flg) {
				SendMail send = new SendMail();

				try {
					send.send(mail);
					System.out.println(mail);
					response.getWriter().write("已成功发送链接邮件，请注意查�?");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				response.getWriter().write("您輸入的用戶不存在！");
			}
		} else {
			response.getWriter().write("密码找回失败�?");
		}
	}

}
