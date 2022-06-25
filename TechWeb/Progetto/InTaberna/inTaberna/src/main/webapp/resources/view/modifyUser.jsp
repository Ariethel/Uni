<%@ page import="model.Utente" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 25/06/22
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify User</title>
</head>
<body>
    <%Utente u = (Utente) request.getAttribute("utente");%>

    <form action="confirm-update">
        <label for="username">Username</label><br>
        <input type="text" name="username" id="username" value="<%=u.getEmail()%>"><br>
        <label for="password">Password</label><br>
        <input type="text" name="password" id="password" value="<%=u.getPassword()%>"><br>
        <label for="tipo">Tipo</label><br>
        <input type="text" name="tipo" id="tipo" value="<%=u.getTipo()%>"><br>
        <input type="hidden" name="id" value="<%=u.getEmail()%>">
        <input type="submit" value="Salva">
    </form>
</body>
</html>
