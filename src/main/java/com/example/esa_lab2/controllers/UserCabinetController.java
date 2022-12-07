package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.OrderServiceImpl;
import com.example.esa_lab2.dto.ShoppingCardElementRecord;
import com.example.esa_lab2.entities.Element;
import com.example.esa_lab2.entities.Order;
import com.example.esa_lab2.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserCabinetController {

    public UserCabinetController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    private OrderServiceImpl orderService;

    @GetMapping("/lk_user")
    protected void lk_user(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Integer orderId = (Integer) req.getSession().getAttribute("currentOrderId");
        if (orderId != null) {
            Order currentOrder = orderService.findOrderById(orderId);
            List<ShoppingCardElementRecord> records = new ArrayList<>();

            for (Element element : currentOrder.getElements()) {
                ShoppingCardElementRecord record = new ShoppingCardElementRecord();
                Product product = element.getProduct();
                record.setCost(product.getPrice());
                record.setElementId(element.getCode());
                record.setName(product.getName());
                record.setPictureUrl(product.getPicture());
                record.setProductId(product.getId());
                records.add(record);
            }

            req.setAttribute("shoppingCardList", records);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lk_user.jsp");
        requestDispatcher.forward(req, resp);
    }

    @GetMapping("/lk_admin")
    protected void lk_admin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.getOrdersForAdmin();
        orders = orders.stream().filter(order -> order.getStatus().equals("Accepted")).collect(Collectors.toList());
        req.setAttribute("orders", orders);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lk_admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
