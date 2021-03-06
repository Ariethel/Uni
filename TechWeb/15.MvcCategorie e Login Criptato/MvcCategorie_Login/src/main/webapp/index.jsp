<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
    <title>Product Table</title>
</head>
<body>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");%>
<%ArrayList<Categoria> categorie = (ArrayList<Categoria>) request.getServletContext().getAttribute("categorie");%>
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
<br/>
<form action="categoria-servlet" method="get"> <!--Stampa delle categorie nel selection box -->
    <select name="categoria">
        <%for (Categoria c: categorie){ %>
            <option value=<%=c.getId()%> ><%=c.getNome()%></option>
        <%}%>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>