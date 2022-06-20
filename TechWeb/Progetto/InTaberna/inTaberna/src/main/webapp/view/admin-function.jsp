<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="../resources/css/head.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
  <title>InTaberna - Music Store</title>
  <link rel="icon" href="../resources/icons/icon.png" type="image/icon type">
</head>

<body>
<div class="navbar">
  <div class="logo">
    <h3 class="logo"><a class="logo" href="index.jsp">In Taberna</a></h3>
  </div>

  <div class="search">
    <form action="" method="get" class="search">
      <input type="search" name="search" size="20">
      <input type="submit" value="🔍">
    </form>
  </div>

  <div class="buttons">
    <ul class="buttons">
      <li class="buttons"><a class="buttons" href="#HOME">🛒</a></li>
      <li class="buttons"><a class="buttons" href="view/login.jsp">Log-In</a></li>
      <li class="buttons"><a class="buttons" href="view/help.jsp">Help</a></li>
    </ul>

  </div>
</div>
<div>
  <h3>Gestisci utenti</h3>
  //Usare ajax per prendere tutti gli utenti
</div>
<div>
  <h3>Gestisci Album</h3>
  //Usare ajax per prendere tutti gli album
  <div id="addAlbum">
    <form action="../addalbumservlet" method="get">
      <input type="text" name="titolo" placeholder="Titolo">
      <input type="number" name="prezzo" placeholder="Prezzo">
      <input type="file" name="img" placeholder="Copertina">
      <input type="number" name="homepage" placeholder="1 -> Homepage/ 0 -> Search Only">
      <input type="submit" value="Invia">
    </form>
  </div>

</div>
</body>

</html>