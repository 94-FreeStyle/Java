package jbw.shop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CodeSetFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");// 只处理了POST请求
		response.setContentType("text/html;charset=utf-8");// 处理响应的编�?
		// �?始处理get请求的乱码问�?
		CodeSetRequest getRequest = new CodeSetRequest(
				(HttpServletRequest) request);
		chain.doFilter(getRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
