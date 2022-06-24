<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="../css/head.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
  <title>InTaberna - Music Store</title>
  <link rel="icon" href="../icons/icon.png" type="image/icon type">

</head>

<body>
<script>
  $(document).ready(function(){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
      if (this.readyState==4 && this.status==200) {
        var obj = JSON.parse(this.responseText);
        for (var i = 0; i < obj.length; i++){
          $("#userList p").append(obj[i].name);
        }
      }
    }
    xmlhttp.open("GET","../../getUser",true);
    xmlhttp.send();
  })

</script>

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
  <div id="userList">
    <p></p>
  </div>
</div>
<div>
  <h3>Gestisci Album</h3>
  //Usare ajax per prendere tutti gli album
  <div id="addAlbum">
    <form action="../addalbumservlet" method="post" enctype="multipart/form-data">
      <input type="text" name="titolo" placeholder="Titolo">
      <input type="number" name="prezzo" step="any" min=”0″ placeholder="Prezzo">
      <input type="file" name="file" placeholder="Copertina">
      <label for="homepage">homepage</label>
      <input type="checkbox" id="homepage" name="homepage">
      <input type="submit" value="Invia">
    </form>
  </div>

</div>
</body>

</html>