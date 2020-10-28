package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/*"})
public class Utf8Filter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// CODE XỬ LÝ REQUEST
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		// CODE XỬ LÝ RESPONSE
		response.setCharacterEncoding("UTF-8");
	}

}
