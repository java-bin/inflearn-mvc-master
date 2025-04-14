package io.servlet.inflearnmvcmaster.model;

import io.servlet.inflearnmvcmaster.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<String, Member> store = new HashMap<>();

    public void save(Member member) {
        store.put(member.getUsername(), member);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
