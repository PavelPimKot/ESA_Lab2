package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.*;
import com.example.esa_lab2.entities.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class ItemsController {

    public ItemsController(SectionServiceImpl sectionService,
                           ProductServiceImpl productService,
                           ClientServiceImpl clientService,
                           OrderServiceImpl orderService,
                           ElementServiceImpl elementService) {
        this.productService = productService;
        this.sectionService = sectionService;
        this.clientService = clientService;
        this.orderService = orderService;
        this.elementService = elementService;
    }

    private SectionServiceImpl sectionService;

    private ProductServiceImpl productService;

    private ClientServiceImpl clientService;

    private OrderServiceImpl orderService;

    private ElementServiceImpl elementService;


    @GetMapping("/items")
    protected void items(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer categoryId = 0;
        Integer sectionId = 0;
        if (req.getParameter("categoryId") != null) {
            categoryId = Integer.parseInt(req.getParameter("categoryId"));
        } else {
            if (req.getSession().getAttribute("currentCategoryId") != null) {
                categoryId = (Integer) req.getSession().getAttribute("currentCategoryId");
            }
        }
        if (req.getParameter("sectionId") != null) {
            sectionId = Integer.parseInt(req.getParameter("sectionId"));
        } else {
            if (req.getSession().getAttribute("sectionId") != null) {
                sectionId = (Integer) req.getSession().getAttribute("sectionId");
            }
        }

        List<Product> products = productService.getProducts();
        if (categoryId != 0) {
            Integer finalCategoryId = categoryId;
            products = products.stream()
                    .filter(product -> product.getCategory().getId().equals(finalCategoryId))
                    .collect(Collectors.toList());
            req.getSession().setAttribute("currentCategoryId", categoryId);
        }
        if (sectionId != 0) {
            Integer finalSectionId = sectionId;
            products = products.stream()
                    .filter(product -> product.getSection().getId().equals(finalSectionId))
                    .collect(Collectors.toList());
            req.getSession().setAttribute("currentSectionId", sectionId);
        }
        req.setAttribute("products", products);

        List<Section> sections = sectionService.getSections();
        req.setAttribute("sections", sections);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("items.jsp");
        requestDispatcher.forward(req, resp);
    }

    @GetMapping("/buy_item")
    protected void buyItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("productId"));
        Integer currentUserId = (Integer) req.getSession().getAttribute("currentUserId");
        Client client = clientService.getClient(currentUserId);
        List<Order> orderList = orderService.getOrdersByUserId(currentUserId);
        Optional<Order> currOrder = orderList.stream().filter(order -> order.getStatus().equals("In Progress")).findFirst();
        Product product = productService.findProductById(id);
        if (currOrder.isPresent()) {
            Order order = currOrder.get();
            Element element = new Element();
            element.setCount(1);
            element.setOrder(order);
            element.setProduct(product);
            req.getSession().setAttribute("currentOrderId", order.getId());
            elementService.save(element);
        } else {
            Order order = new Order();
            order.setClient(client);
            order.setStatus("In Progress");
            order.setCost(0);
            order.setOrderDate(new Date());
            order.setDeliveryDate(new Date());
            orderService.save(order);
            req.getSession().setAttribute("currentOrderId", order.getId());
            Element element = new Element();
            element.setCount(1);
            element.setOrder(order);
            element.setProduct(product);
            elementService.persist(element);
        }
        resp.sendRedirect("items");
    }
}
