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

@WebServlet(name = "urlParamServlet", urlPatterns = "/urlParam")
public class URLParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // korean
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // single
        String username = request.getParameter("username");
        out.println("single param username = " + username);

        // multi
        String[] items = request.getParameterValues("item");
        if (items != null) {
            out.println("multi item[] = " + Arrays.toString(items));
        } else {
            out.println("no item[]");
        }

        // all - map
        Map<String, String[]> paramMap = request.getParameterMap();
        String allParams = paramMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + Arrays.toString(e.getValue()))
                .collect(Collectors.joining(", "));
        out.println("all params = " + allParams);
    }
}
