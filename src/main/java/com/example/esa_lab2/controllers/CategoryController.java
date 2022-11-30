package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.CategoryServiceImpl;
import com.example.esa_lab2.entities.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;


@Controller
public class CategoryController {
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryServiceImpl categoryService;

    @GetMapping("/main")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.getCategories();
        req.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);
    }
}
