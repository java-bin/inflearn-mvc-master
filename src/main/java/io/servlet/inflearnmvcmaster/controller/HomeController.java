package io.servlet.inflearnmvcmaster.controller;

import io.servlet.inflearnmvcmaster.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.List;

// json, xml, text를 반환하기 위해 뷰를 렌더링 하지 않음
@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }

    @GetMapping("/info")
    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request, response);
        String header = servletWebRequest.getHeader("User-Agent");
        System.out.println("header = " + header);

        String name = servletWebRequest.getParameter("name");
        System.out.println("name = " + name);

        HttpServletRequest nativeRequest = servletWebRequest.getNativeRequest(HttpServletRequest.class);
        String requestURI = nativeRequest.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        HttpServletResponse nativeResponse = servletWebRequest.getNativeResponse(HttpServletResponse.class);
//        nativeResponse.setStatus(HttpServletResponse.SC_OK);
//        nativeResponse.getWriter().write("successful");

        servletWebRequest.getResponse().setStatus(HttpServletResponse.SC_OK);
        servletWebRequest.getResponse().getWriter().write("successful");
    }

}
