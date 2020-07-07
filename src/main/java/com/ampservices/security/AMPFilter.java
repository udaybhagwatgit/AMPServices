package com.ampservices.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component

public class AMPFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletResponse httpServletResponse=(HttpServletResponse)response;
	        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
	        httpServletResponse.setHeader("AMP-Access-Control-Allow-Source-Origin", "sameer.patil2@qa.amp.epsilon.com");
		httpServletResponse.setHeader("Access-Control-Expose-Headers", "AMP-Access-Control-Allow-Source-Origin");
	        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
	        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	        httpServletResponse.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, AMP-Access-Control-Allow-Source-Origin");
	        
	        chain.doFilter(request, response);		
	}

	@Override
	public void destroy() {
		
	}

}
