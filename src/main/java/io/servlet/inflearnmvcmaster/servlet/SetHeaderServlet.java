package io.servlet.inflearnmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "setHeaderServlet", urlPatterns = "/setHeader")
public class SetHeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("X-Custom-Header", "X-Custom-Value");
        response.setHeader("X-Custom-Header", "X-Custom-Value2"); // 덮어씀

        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("X-Custom-Header: X-Custom-Value 헤더로 설정했습니다.");
    }
}
