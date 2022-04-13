<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 12/04/22
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
    <title>Categoria scelta</title>
</head>
<body>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");%>
<table class="table">
<tr style="background-color: palegreen">
    <th>ID</th>
    <th>Nome</th>
    <th>Descrizione</th>
    <th>Prezzo</th>
</tr>
<%for (Prodotto p: prodotti){ %> <!-- stampa dei prodotti -->
<tr>
    <th><%=p.getId()%></th>
    <th><%=p.getNome()%></th>
    <th><%=p.getDescrizione()%></th>
    <th><%=p.getPrezzo()%></th>
</tr>
<%}%>
</table>
</body>
</html>
