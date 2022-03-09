<!DOCTYPE html>
<html>
<head>
    <title>Risultati</title>
    <link rel="stylesheet"
          href="./css/styles.css"
          type="text/css"/>
</head>
<body>
<h2> Esito Registrazione</h2>
<p>La registrazione di ${customerJsp.fname} e' andata a buon fine.</p>
<p>I suoi dati sono:</p>
<fieldset>
    <p>Cognome: ${customerJsp.lname}</p>
    <p>Data nascita: ${customerJsp.dnascita}</p>
    <p>Male: ${customerJsp.genderA}</p>
    <p>Female: ${customerJsp.genderB}</p>
    <p>Citta: ${customerJsp.citta}</p>
    <p>Provincia: ${customerJsp.provincia}</p>
    <p>CAP: ${customerJsp.cap}</p>
    <p>Strada: ${customerJsp.strada}</p>
    <p>CartaID: ${customerJsp.idcard}</p>
    <p>Email: ${customerJsp.email}</p>
    <p>Phone: ${customerJsp.phone}</p>
    <p>Website: ${customerJsp.website}</p>
</fieldset>
</body>
</html>
