<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/Yettodo">
    <label> Nome</label>
    <input type="text" id="fname" name="fname"><br>
    <label> Cognome</label>
    <input type="text" id="lname" name="lname"><br>
    <label> Nascita</label>
    <input type="date" id="dnascita" name="dnascita"><br>
    <input type="radio" id="male" name="gender">
    <label for="male">MALE</label><br>
    <input type="radio" id="female" name="gender">
    <label for="female">FEMALE</label><br>
    <label >Citta</label>
    <input type="text" id="Citta"><br>
    <label >Provincia</label>
    <input type="text" id="Provincia"><br>
    <label >CAP</label>
    <input type="number" id="CAP"><br>
    <label >Strada</label>
    <input type="text" id="Strada"><br>
    <label >N. Carta ID</label>
    <input type="number" id="idcard"><br>
    <label >Email</label>
    <input type="email" id="email"><br>
    <label >Phone</label>
    <input type="number" id="phone"><br>
    <label >Website</label>
    <input type="url" id="website"><br>
    <input type="submit" value="Invia">
</form>
</body>
</html>