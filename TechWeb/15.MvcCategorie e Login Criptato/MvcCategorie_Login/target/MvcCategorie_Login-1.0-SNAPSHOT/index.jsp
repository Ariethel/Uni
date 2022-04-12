<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Product Table</title>
</head>
<body>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");%>
<%ArrayList<Categoria> categorie = (ArrayList<Categoria>) request.getServletContext().getAttribute("categorie");%>
<table>
    <tr>
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