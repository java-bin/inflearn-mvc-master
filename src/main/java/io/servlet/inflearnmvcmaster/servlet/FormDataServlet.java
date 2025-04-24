package io.servlet.inflearnmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "formDataServlet", urlPatterns = "/formTest")
public class FormDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // korean
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("=== [GET] FORM DATA ===");

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("name = " + name);
        out.println("age = " + age);

        // all - map
        Map<String, String[]> paramMap = request.getParameterMap();
        String allParams = paramMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + String.join("/", e.getValue()))
                .collect(Collectors.joining(", "));
        out.println("all params = " + allParams);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // korean
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("=== [POST] FORM DATA ===");

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("name = " + name);
        out.println("age = " + age);

        // all - map
        Map<String, String[]> paramMap = request.getParameterMap();
        String allParams = paramMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + String.join("/", e.getValue()))
                .collect(Collectors.joining(", "));
        out.println("all params = " + allParams);
    }
}
