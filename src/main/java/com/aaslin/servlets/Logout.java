package com.aaslin.servlets;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false); 

        if (session != null) {
            session.invalidate(); 
            
        } else {
        	response.getWriter().println("No active session to invalidate.");
        }
        response.sendRedirect("index.jsp?message=Logged+out+successfully");

    }
}