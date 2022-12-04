package com.example.esa_lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@SpringBootApplication
public class EsaLab2Application {

    @Bean
    public ViewResolver getXSLTViewResolver(){

        XsltViewResolver xsltResolover = new XsltViewResolver();
        xsltResolover.setOrder(1);

        xsltResolover.setViewClass(XsltView.class);
        xsltResolover.setViewNames("categories", "orders");
        xsltResolover.setPrefix("/WEB-INF/xsl/");
        xsltResolover.setSuffix(".xsl");

        return xsltResolover;
    }

    public static void main(String[] args) {
        SpringApplication.run(EsaLab2Application.class, args);
    }

}
