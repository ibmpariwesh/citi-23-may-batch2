package com.javatechie.spring.zulu.api.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	  @Override
	  public String filterType() {
	    return "post";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    log.info("PreFilter 2: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
	    
	    log.info("PostFilter: " + String.format("response's content type is %s", response.getStatus()));
	    
	    return null;
	  }
}