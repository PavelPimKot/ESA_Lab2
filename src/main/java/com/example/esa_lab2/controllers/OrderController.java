package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.ElementServiceImpl;
import com.example.esa_lab2.beans.service.impl.OrderServiceImpl;
import com.example.esa_lab2.entities.Element;
import com.example.esa_lab2.entities.Order;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    @Autowired
    private ElementServiceImpl elementService;

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/offerOrder")
    public void offerOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderService.findOrderById((Integer) req.getSession().getAttribute("currentOrderId"));
        int totalCost = 0;
        for (Element element : order.getElements()) {
            element.setCount(Integer.parseInt(req.getParameter(element.getCode().toString())));
            totalCost += element.getCount() * element.getProduct().getPrice();
            elementService.save(element);
        }
        order.setStatus("Accepted");
        order.setCost(totalCost);
        orderService.save(order);
        req.getSession().removeAttribute("currentOrderId");
        resp.sendRedirect("lk_user");
    }

    @GetMapping("/markOrderReady")
    public void markOrderReady(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderService.findOrderById(Integer.parseInt(req.getParameter("orderId")));
        order.setStatus("Issued");
        orderService.save(order);
        resp.sendRedirect("main.jsp");
    }

    @GetMapping("/my_orders")
    protected void myOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Integer clientId = (Integer) req.getSession().getAttribute("currentUserId");
        List<Order> orders = orderService.getOrdersForClient(clientId);
        if (!orders.isEmpty()) {
            orders = orders.stream().filter(order -> !order.getStatus().equals("In Progress")).collect(Collectors.toList());
            req.setAttribute("orders", orders);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("my_orders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
