<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web</title>
</head>
<body>

<h2>Дата</h2>
<%!
    Date theDate = new Date();
    Date getDate() {
        System.out.println( "In getDate() method" );
        return theDate;
    }%>

<h3> The time is now <%= getDate() %> </h3>


</body>
</html>
