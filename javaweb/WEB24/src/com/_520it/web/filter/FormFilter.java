package com._520it.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FormFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();
		System.out.println(method);

		if (method.equals("POST")) {
			// postÃ·Ωª
			req.setCharacterEncoding("utf-8");
			
		}
		chain.doFilter(req, response);
	}

}
