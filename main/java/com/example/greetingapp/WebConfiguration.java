package com.example.greetingapp;


import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;

@Configuration
public class WebConfiguration {
    @Bean

    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebdavServlet());
        registrationBean.addUrlMappings("/h2/*");
        return registrationBean;
    }
}
