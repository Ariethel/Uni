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
    <ul>
        <c:forEach items="${customers}" var="customer">
        <li>${customer.firstName} ${customer.lastName} ${customer.balance}
            <form action="update-customer">
                <input type="hidden" name="id" value="${customer.id}">
                <input type="submit" value="Modifica">
            </form>
        </li>
        </c:forEach>
    </ul>
</body>
</html>
