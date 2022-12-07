package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.AdminServiceImpl;
import com.example.esa_lab2.beans.service.impl.CategoryServiceImpl;
import com.example.esa_lab2.beans.service.impl.ClientServiceImpl;
import com.example.esa_lab2.entities.Admin;
import com.example.esa_lab2.entities.Category;
import com.example.esa_lab2.entities.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AuthorizationController {

    public AuthorizationController(AdminServiceImpl adminService,
                                   CategoryServiceImpl categoryService,
                                   ClientServiceImpl clientService) {
        this.adminService = adminService;
        this.categoryService = categoryService;
        this.clientService = clientService;
    }

    private AdminServiceImpl adminService;

    private ClientServiceImpl clientService;

    private CategoryServiceImpl categoryService;


    @GetMapping("/logIn")
    protected void logIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        List<Client> client = clientService.findClientByLoginAndPassword(login, password);
        List<Admin> admin = adminService.findAdminByLoginAndPassword(login, password);
        List<Category> categories = categoryService.getCategories();
        if (!client.isEmpty()) {
            req.getSession().setAttribute("currentUserId", client.get(0).getId());
            req.getSession().setAttribute("categories", categories);
            req.getSession().setAttribute("userRole", "Client");
            resp.sendRedirect("main.jsp");
        } else {
            if (!admin.isEmpty()) {
                req.getSession().setAttribute("currentUserId", admin.get(0).getId());
                req.getSession().setAttribute("categories", categories);
                req.getSession().setAttribute("userRole", "Admin");
                resp.sendRedirect("main.jsp");
            } else {
                req.getSession().setAttribute("errorMessage", "Пользователя с таким логином  и паролем не существует");
                resp.sendRedirect("error.jsp");
            }
        }
    }

    @GetMapping("/register")
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();

        Client client = new Client();

        client.setFirstName(req.getParameter("user_name"));
        client.setLastName(req.getParameter("user_lastname"));
        client.setMiddleName(req.getParameter("user_secondname"));
        client.setPassword(req.getParameter("user_pass"));
        client.setPhone(req.getParameter("user_phone"));
        client.setAddress(req.getParameter("user_adr"));
        client.setLogin(req.getParameter("user_login"));
        client.setEmail(req.getParameter("user_mail"));
        try {
            Date user_birthday = new SimpleDateFormat("dd.MM.yyyy").parse(req.getParameter("user_birthday"));
            client.setBirthDay(user_birthday);
        } catch (ParseException e) {
            req.getSession().setAttribute("errorMessage", "Некорректный формат даты");
            resp.sendRedirect("error.jsp");
            return;
        }
        clientService.save(client);


        List<Category> categories = categoryService.getCategories();
        req.getSession().setAttribute("categories", categories);
        req.getSession().setAttribute("userRole", "Client");
        req.getSession().setAttribute("currentUserId", client.getId());
        resp.sendRedirect("main.jsp");
    }
}
