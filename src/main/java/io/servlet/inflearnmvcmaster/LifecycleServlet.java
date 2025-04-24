package io.servlet.inflearnmvcmaster;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifecycleServlet", urlPatterns = "/lifecycle", loadOnStartup = -1) // -1은 지연로딩 최초 호출시
public class LifecycleServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Life cycle init() call (Servlet init)");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet() Method run (client)");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello Life cycle Servlet: doGet() response</h2>");
        out.println("<p>Servlet Life cycle Check</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost() Method run (client)");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello Life cycle Servlet: doPost() response</h2>");
        out.println("<p>Servlet Life cycle Check</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Life cycle destroy() call (Servlet destroy)");
    }
}
