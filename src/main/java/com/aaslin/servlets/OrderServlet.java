package com.aaslin.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.aaslin.util.DBConnection;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       
        try {
            Connection conn = DBConnection.getConnection();
            int itemId = Integer.parseInt(req.getParameter("itemID"));
            String itemName = req.getParameter("item_name");
            int qty = Integer.parseInt(req.getParameter("qty"));
            

            PreparedStatement insert = conn.prepareStatement(
                    "INSERT INTO ordersInfo_jerusha (item_id, item_name, qty, order_date) VALUES (?, ?, ?, NOW())",  Statement.RETURN_GENERATED_KEYS);

            insert.setInt(1, itemId);
            insert.setString(2, itemName);
            insert.setInt(3, qty);
            insert.executeUpdate();

            ResultSet keys = insert.getGeneratedKeys();
            int orderId = 0;
            if (keys.next()) {
                orderId = keys.getInt(1);
            }

            req.setAttribute("itemId", itemId);
            req.setAttribute("qty", qty);

            HttpSession session = req.getSession();
            session.setAttribute("orderId", orderId);

            resp.getWriter().write("Order Placed! Order ID: " + orderId);

            insert.close();
            keys.close();
            conn.close();

        } catch (SQLException e) {
            throw new ServletException(e);
        }
        
        
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>"
                + "<body>"
                + "<form method='post' action='order'>"
                + "<label>Enter your itemID: </label>"
                + "<input type='number' name='itemID' required><br><br>"
                + "<label>Enter your item name: </label>"
                + "<input type='text' name='item_name' required><br><br>"
                + "<label>Enter your quantity: </label>"
                + "<input type='number' name='qty' required><br><br>"
                + "<input type='submit'>"
                + "</form>"
                + "</body>"
                + "</html>");
    }
    
}