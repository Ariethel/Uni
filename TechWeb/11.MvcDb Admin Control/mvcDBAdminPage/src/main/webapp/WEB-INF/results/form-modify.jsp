<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 24/03/22
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account modify page</title>
    <link href="./css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <form action="confirm-update">
        <label for="fname">First Name</label><br>
        <input type="text" name="fname" id="fname" value="${customer.firstName}"><br>
        <label for="lname">Last Name</label><br>
        <input type="text" name="lname" id="lname" value="${customer.lastName}"><br>
        <label for="balance">Balance</label><br>
        <input type="text" name="balance" id="balance" value="${customer.balance}"><br>
        <input type="submit" value="Salva">
    </form>
</body>
</html>
