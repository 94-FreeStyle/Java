package jbw.shop.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CodeSetRequest extends HttpServletRequestWrapper {
	/*
	 * 使用装饰者模式创建山寨版的Request来替换原先的Request来解决Get请求的全站乱码问�?
	 */
	public CodeSetRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (getMethod().equals("GET")) {
			try {
				value = new String(value.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
			}
		}
		return value;
	}
}
