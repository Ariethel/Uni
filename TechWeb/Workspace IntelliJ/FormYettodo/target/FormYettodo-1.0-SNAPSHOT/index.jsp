<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="yettodo-servlet">
    <label for="fname"> Nome</label><br>
    <input type="text" id="fname" name="fname"><br>
    <label for="lname"> Cognome</label><br>
    <input type="text" id="lname" name="lname"><br>
    <label for="dnascita"> Nascita</label><br>
    <input type="date" id="dnascita" name="dnascita"><br>
    <input type="radio" id="male" name="genderA">
    <label for="male">MALE</label><br>
    <input type="radio" id="female" name="genderB">
    <label for="female">FEMALE</label><br>
    <label for="citta">Citta</label><br>
    <input type="text" id="citta"><br>
    <label for="provincia">Provincia</label><br>
    <input type="text" id="provincia"><br>
    <label for="cap">CAP</label><br>
    <input type="number" id="cap"><br>
    <label for="strada">Strada</label><br>
    <input type="text" id="strada"><br>
    <label for="idcard">N. Carta ID</label><br>
    <input type="number" id="idcard"><br>
    <label for="email">Email</label><br>
    <input type="email" id="email"><br>
    <label for="phone">Phone</label><br>
    <input type="number" id="phone"><br>
    <label for="website">Website</label><br>
    <input type="url" id="website"><br>
    <input type="submit" value="Invia">
</form>
</body>
</html>