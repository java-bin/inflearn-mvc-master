<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="io.servlet.inflearnmvcmaster.Member" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register List - Model1</title>
</head>
<body>
<h1>Register List (Model1)</h1>
<%
    List<Member> members = (List<Member>) request.getAttribute("members");
    if (members == null) {
        members = List.of();
    }
%>
<ul>
    <%
        for (Member member : members) {
    %>
    <li><%= member.getUsername() %> / <%= member.getPassword() %></li>
    <%
        }
    %>
</ul>
<a href="/model2/registerForm">Go to Register Form</a>
</body>
</html>
