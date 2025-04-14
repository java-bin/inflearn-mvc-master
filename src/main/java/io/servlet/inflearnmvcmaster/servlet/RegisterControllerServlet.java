package io.servlet.inflearnmvcmaster.servlet;

import io.servlet.inflearnmvcmaster.Member;
import io.servlet.inflearnmvcmaster.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterControllerServlet", urlPatterns = "/model2/register")
public class RegisterControllerServlet extends HttpServlet {

    private final MemberRepository memberRepository = new MemberRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member member = new Member(username, password);
        memberRepository.save(member);

        response.sendRedirect(request.getContextPath() + "/model2/list");
    }
}
