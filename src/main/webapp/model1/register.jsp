<%@ page import="io.servlet.inflearnmvcmaster.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%
    request.setCharacterEncoding("UTF-8");

    List<Member> memberList = (List<Member>) application.getAttribute("memberList");
    if (memberList == null) {
        memberList = new ArrayList<>();
    }

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && !username.isEmpty()) {
        Member newMember = new Member(username, password);
        memberList.add(newMember);

        application.setAttribute("memberList", memberList);
        response.sendRedirect("/model1/list.jsp");
    }
%>
