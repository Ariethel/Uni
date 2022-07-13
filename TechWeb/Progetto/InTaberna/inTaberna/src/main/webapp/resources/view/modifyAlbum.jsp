<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Album" %><%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 25/06/22
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Album</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <% Album a = (Album) request.getAttribute("album");%>


    <form action="confirm-updateAlbum">
        <label for="title">Title</label><br>
        <input type="text" name="title" id="title" value="<%=a.getTitolo()%>"><br>
        <label for="prezzo">Prezzo</label><br>
        <input type="number" name="prezzo" id="prezzo" value="<%=a.getPrezzo()%>"><br>
        <label for="homepage">Homepage</label><br>
        <input type="checkbox" name="homepage" id="homepage"><br>
        <input type="hidden" name="id" value="<%=a.getTitolo()%>">
        <input type="submit" value="Salva">
    </form>

</body>
</html>
