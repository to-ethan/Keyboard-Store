package com.ethan.keyboardstore.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class LogRequestFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(LogRequestFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL()));
		
		// Zuul currently ignores the return type, so it is sufficient to return null.
		return null;
	}

	@Override
	public String filterType() {
		// Four values: pre post route error
		return "pre";
	}

	@Override
	public int filterOrder() {
		// Prioritizes from lowest to highest
		return 1;
	}

}
