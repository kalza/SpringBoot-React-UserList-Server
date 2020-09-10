package com.example.demo.config;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter{

	private static final Logger logger = Logger.getLogger("CORSFilter.class");
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		logger.info("doFilter()");
		
		HttpServletResponse res = (HttpServletResponse) response;		
		
		
		// @CrossOrigin 어노테이션으로 대체 가능 (Spring 4.2↑)
		res.setHeader("Access-Control-Allow-Origin" , "*");
		res.setHeader("Access-Control-Allow-Credentials" , "true");
		res.setHeader("Access-Control-Allow-Methods" , "POST, GET, PUT, OPTIONS, DELETE");		
		res.setHeader("Access-Control-Allow-Max-Age" , "3600");
		res.setHeader("Access-Control-Allow-Headers" , "X-Requested-With, Content-Type, uthorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		
		chain.doFilter(request, res);			
		
	}
}