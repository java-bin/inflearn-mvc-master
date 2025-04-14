package io.servlet.inflearnmvcmaster.controller;

import io.servlet.inflearnmvcmaster.Member;
import io.servlet.inflearnmvcmaster.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListController implements Controller {

    private final MemberRepository memberRepository = new MemberRepository();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        return "/WEB-INF/jsp/frontList.jsp";
    }
}
