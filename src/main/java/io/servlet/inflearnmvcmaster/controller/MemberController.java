package io.servlet.inflearnmvcmaster.controller;

import io.servlet.inflearnmvcmaster.Member;
import io.servlet.inflearnmvcmaster.model.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// spring mvc에서 사용되며 properties에 따라 jsp파일을 찾아감
@Controller
@RequestMapping("/spring-controller")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new-form")
    public String showForm() {
        return "frontForm";
    }

    @PostMapping("/members/save")
    public String saveMember(Member member, Model model) {
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "frontResult";
    }

    @GetMapping("/members/list")
    public String listMember(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "frontList";
    }

}
