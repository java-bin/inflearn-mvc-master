package io.servlet.inflearnmvcmaster.controller;

import io.servlet.inflearnmvcmaster.Member;
import io.servlet.inflearnmvcmaster.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveController implements Controller {

    private final MemberRepository memberRepository = new MemberRepository();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member member = new Member(username, password);
        memberRepository.save(member);

        request.setAttribute("member", member);

        return "/WEB-INF/jsp/frontResult.jsp";
    }
}
