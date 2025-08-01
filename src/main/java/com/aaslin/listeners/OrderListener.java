package com.aaslin.listeners;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class OrderListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        Object itemId = event.getServletRequest().getAttribute("itemId");
        Object qty = event.getServletRequest().getAttribute("qty");

        if (itemId != null && qty != null) {
            System.out.println("Order Date: " + new Date() +
                               ", Item ID: " + itemId +
                               ", Item Qty :" + qty);
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {}
}