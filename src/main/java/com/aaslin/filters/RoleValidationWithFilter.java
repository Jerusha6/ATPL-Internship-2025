package com.aaslin.filters;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class RoleValidationWithFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	       
	    
	        PrintWriter out = response.getWriter();
	        String role = request.getParameter("role");
	        
	        if(!"admin".equalsIgnoreCase(role)) {
	        	out.println("Only Admins have access");
	        	out.println("<a href='collectAdminData'>Go Back</a>");
	        	return;
	        }
	        filterChain.doFilter(request, response);
	     
	    
	}
}
