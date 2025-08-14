package com.aaslin.DispatcherServletFlowTracing.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomeInterceptor implements HandlerInterceptor {
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

	        try {
	            System.out.println("preHandle() method called: ");
	            System.out.println("Method Type: " + request.getMethod());
	            System.out.println("Request URL: " + request.getRequestURI());
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        try {
	            System.out.println("postHandle() is called after completion of preHandle, and request served, before response to the client)");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        try {
	            System.out.println("afterCompletion() is called after completion of preHandle() and postHandle() methods");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
