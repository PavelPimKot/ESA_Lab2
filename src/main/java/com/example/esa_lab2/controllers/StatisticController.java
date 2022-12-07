package com.example.esa_lab2.controllers;

import com.example.esa_lab2.beans.service.impl.StatisticServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class StatisticController {

    public StatisticController(StatisticServiceImpl statisticService) {
        this.statisticService = statisticService;
    }

    private StatisticServiceImpl statisticService;

    @GetMapping("/statistic")
    protected void statistic(HttpServletResponse resp) throws IOException {
        statisticService.writeSalesStatisticInFile("C:\\Users\\iraur\\Desktop\\GeekShop\\StatFilesDir", "Statistic.txt");
        resp.sendRedirect("lk_admin");
    }
}
