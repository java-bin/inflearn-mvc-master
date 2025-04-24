package io.servlet.inflearnmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "setStatusServlet", urlPatterns = "/setStatus")
public class SetStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("HTTP Status를 403 FORBIDDEN 으로 설정했습니다.");
    }
}
