package jbw.shop.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 此类将作为项目中其他servlet的直接父类，通过继承HttpServlet并重写其处理
 * 请求方法的services方法，�?�过反射来执行被调用的方法，这样就可以自己在真正�?
 * servlet中自定义许多方法，这样就减少了可能需要写大量的servlet来处理前台的大量请求
 * 
 */
public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 思想 1.获得请求的方法名�? 2.利用方法名称将方法变为Method对象 3.利用invoke（）�?活相应的方法
		 */

		// 1.获得方法名称
		String methodName = request.getParameter("method");

		// 2.得到Method对象
		Method method = null;
		try {
			method = this.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您调用的Method�?" + methodName + "不存在！", e);
		}

		// 3.执行方法
		try {
			String result = (String) method.invoke(this, request, response);
			String[] res = result.split(":");
			if ((result != null) && (!result.trim().isEmpty())) {
				if (res[0].equals("f")) {
					request.getRequestDispatcher(res[1]).forward(request,
							response);
				} else if (res[0].equals("r")) {
					response.sendRedirect(request.getContextPath() + res[1]);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
