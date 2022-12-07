package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.CategoryServiceImpl;
import com.example.esa_lab2.entities.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@RestController
public class CategoryController {
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryServiceImpl categoryService;

    @GetMapping("/main")
    protected void getCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.getCategories();
        req.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCategories() throws JsonProcessingException {
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok().body(new ObjectMapper().writeValueAsString(categories));
    }

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_XML_VALUE)
    public ModelAndView getCategoriesXml() throws JsonProcessingException {
        List<Category> categories = categoryService.getCategories();
        ModelAndView modelAndView = new ModelAndView("categories");
        Source source = new StreamSource(new ByteArrayInputStream(new XmlMapper().writeValueAsBytes(categories)));
        modelAndView.addObject(source);
        return modelAndView;
    }
}
