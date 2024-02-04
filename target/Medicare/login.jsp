<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script>
        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if (errorMessage != null && !errorMessage.isEmpty()) {%>
               alert("<%= errorMessage %>");
        <% } %>
    </script>
</head>
<body>
<form action="<%= request.getContextPath()%>/SiteController" method="post">
Username: <input type="text" name="username"> <br/>
Password: <input type="password" name="password"> <br/>
<input type="submit" value="Login">
</form>
</body>
</html>