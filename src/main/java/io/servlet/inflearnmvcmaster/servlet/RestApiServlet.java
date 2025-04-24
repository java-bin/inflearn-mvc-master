package io.servlet.inflearnmvcmaster.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "restApiServlet", urlPatterns = "/restTest")
public class RestApiServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // korean
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String contentType = request.getContentType();
        out.println("Content-Type: " + contentType);

        if (contentType == null) {
            out.println("No Content-Type");
            return;
        }

        if (contentType.startsWith("text/plain")) {
            handlerPlainText(request, out);
        } else if (contentType.startsWith("application/json")) {
            handlerJson(request, out);
        } else {
            out.println("not support Content-Type");
        }
    }

    private void handlerPlainText(HttpServletRequest request, PrintWriter out) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder builder = new StringBuilder(); // for text
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        out.println("[PlainText] body: " + builder.toString());
    }

    private void handlerJson(HttpServletRequest request, PrintWriter out) throws IOException {
        InputStream inputStream = request.getInputStream();
        Map<?, ?> jsonMap = objectMapper.readValue(inputStream, HashMap.class);
        out.println("[JSON] parsing Data(Map): " + jsonMap.toString());
        if (jsonMap.containsKey("name")) {
            out.println("name: " + jsonMap.get("name"));
        }
        if (jsonMap.containsKey("age")) {
            out.println("age: " + jsonMap.get("age"));
        }
    }
}
