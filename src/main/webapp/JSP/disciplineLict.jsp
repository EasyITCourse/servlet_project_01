<%@ page import="entity.Discipline" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web</title>
</head>
<body>
<h3>Discipline</h3>
<%
    List<Discipline> listDisc = (List<Discipline>) request.getAttribute("list");

    for (Discipline iter : listDisc) {
        int i = iter.getId();
        String str = iter.getName();
%>
    <%="id: " + i+"; "%>
    <%="name: " + str+"; "%>
    <br>
<%
    }
%>
<p>
    <a href="home.php">Назад</a>
</p>
</body>
</html>
