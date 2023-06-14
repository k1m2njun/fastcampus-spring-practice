package com.fastcampus.springpractice.web;

import com.fastcampus.springpractice.config.Config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 여기에는 Web이 붙어있다.
        // 어플리케이션 컨텍스트를 만들고, 디스패쳐서블릿을 초기화하고 등록해주는데,
        // 서블렛 컨테이너에 의해서 자동으로 발견된다.
        context.register(Config.class); // Config은 아까 만든 컨텍스트.

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
