package io.servlet.inflearnmvcmaster.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet(name = "requestInfoServlet", urlPatterns = "/requestApi")
public class HttpRequestServletApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plane; charset=UTF-8");
        PrintWriter out = response.getWriter();

        printLine(out, "");
        printLine(out, "");
        printLine(out, "");

        // 1. HEADER API
        printLine(out, "[1] Header 관련 ----------");
        Collections.list(request.getHeaderNames())
                .forEach(headerName -> {
                    printLine(out, " - " + headerName);
                });

        printLine(out, "User-Agent : " + request.getHeader("User-Agent"));

        // Others
        String cookieHeader = "Cookie";
        if (request.getHeader(cookieHeader) != null) {
            printLine(out, "Cookie Header All");

            Collections.list(request.getHeaders(cookieHeader))
                    .forEach(value -> {
                        printLine(out, " - " + value);
                    });
        }
        printLine(out, "");

        // 2. Request Method & Path
        printLine(out, "[2] Request Method & Path ----------");
        printLine(out, "request.getMethod() : " + request.getMethod());
        printLine(out, "request.getRequestURI() : " + request.getRequestURI());
        printLine(out, "request.getRequestURL() : " + request.getRequestURL());
        printLine(out, "request.getContextPath() : " + request.getContextPath());
        printLine(out, "request.getServletPath() : " + request.getServletPath());
        printLine(out, "request.getPathInfo() : " + request.getPathInfo());

        // 3. Session Attribute
        printLine(out, "[3] Session Attribute ----------");
        HttpSession session = request.getSession(true);

        if (session == null) {
            printLine(out, "No Session");
        } else {
            printLine(out, "Session ID : " + session.getId());
            printLine(out, "Requested Session ID : " + request.getRequestedSessionId());

            // Session
            Collections.list(session.getAttributeNames())
                    .forEach(attrName -> {
                        Object val = session.getAttribute(attrName);
                        printLine(out, " - " + attrName + " : " + val);
                    });
        }
        printLine(out, "");

        // 4. Request Attribute
        printLine(out, "[4] Request Attribute ----------");
        printLine(out, "Request Attribute List");
        printLine(out, "");

        Collections.list(request.getAttributeNames())
                .forEach(attrName -> {
                    Object val = session.getAttribute(attrName);
                    printLine(out, " - " + attrName + " : " + val);
                });
        // Attribute Add
        request.setAttribute("customAttr", "customValue");
        printLine(out, "customAttr Add : " + request.getAttribute("customAttr"));
        printLine(out, "");
        // Attribute Remove
        request.removeAttribute("customAttr");
        printLine(out, "customAttr Removed : " + request.getAttribute("customAttr"));
        printLine(out, "");

        // 5. Remote & Local Info
        printLine(out, "[5] Remote & Local Info ----------");
        printLine(out, "request.getRemoteAddr() : " + request.getRemoteAddr());
        printLine(out, "request.getRemoteHost() : " + request.getRemoteHost());
        printLine(out, "request.getRemotePort() : " + request.getRemotePort());
        printLine(out, "request.getLocalAddr() : " + request.getLocalAddr());
        printLine(out, "request.getLocalName() : " + request.getLocalName());
        printLine(out, "request.getLocalPort() : " + request.getLocalPort());
        printLine(out, "");

        // 6. Metadata
        printLine(out, "[6] Metadata ----------");
        printLine(out, "request.getContextPath() : " + request.getContextPath());
        printLine(out, "request.getContentLength() : " + request.getContentLength());
        printLine(out, "request.getProtocol() : " + request.getProtocol());
        printLine(out, "request.getScheme() : " + request.getScheme());
        printLine(out, "request.getServerName() : " + request.getServerName());
        printLine(out, "request.getServerPort() : " + request.getServerPort());
        printLine(out, "");
    }

    private void printLine(PrintWriter out, String message) {
        System.out.println(message); // console
        out.println(message); // browser
    }
}
