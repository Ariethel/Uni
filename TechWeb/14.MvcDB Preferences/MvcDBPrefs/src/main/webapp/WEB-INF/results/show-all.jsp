<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 24/03/22
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>show all account</title>
    <link href="./css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<a href="index.html">Torna alla Home</a>
<p style="color: green">I preferiti sono mostrati in verde</p>

<form action="load-prefs"> <input type="submit" value="Carica Preferiti"> </form>


<form action="store-prefs"> <input type="submit" value="Salva Preferiti"> </form>

<ul>
    <c:forEach items="${customers}" var="customer">
        <c:if test = "${customer.bookmark}">
            <li style="color: green">${customer.firstName} ${customer.lastName} ${customer.balance}</li>
        </c:if>
        <c:if test = "${!customer.bookmark}">
            <li>${customer.firstName} ${customer.lastName} ${customer.balance}</li>
        </c:if>


            <form action="update-customer">
                <input type="hidden" name="id" value="${customer.id}">
                <input type="submit" value="Modifica">
            </form>

            <form action ="add-prefs">
                <input type="hidden" name="id" value="${customer.id}">
                <input type="submit" value="Aggiungi ai preferiti">
            </form>

            <form action ="remove-prefs">
                <input type="hidden" name="id" value="${customer.id}">
                <input type="submit" value="Rimuovi dai preferiti">
            </form>
        </li>
    </c:forEach>
</ul>
</body>
</html>
