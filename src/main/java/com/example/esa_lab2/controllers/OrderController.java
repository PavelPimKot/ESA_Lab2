package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.ElementServiceImpl;
import com.example.esa_lab2.beans.service.impl.OrderServiceImpl;
import com.example.esa_lab2.entities.Category;
import com.example.esa_lab2.entities.Element;
import com.example.esa_lab2.entities.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
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

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrders() throws JsonProcessingException {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok().body(new ObjectMapper().writeValueAsString(orders));
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_XML_VALUE)
    public ModelAndView getOrdersXml() throws JsonProcessingException {
        List<Order> orders = orderService.getOrders();
        ModelAndView modelAndView = new ModelAndView("orders");
        Source source = new StreamSource(new ByteArrayInputStream(new XmlMapper().writeValueAsBytes(orders)));
        modelAndView.addObject(source);
        return modelAndView;
    }
}
