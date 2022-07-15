<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="../css/index.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="../css/head.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
  <title>InTaberna - Music Store</title>
  <link rel="icon" href="../icons/icon.png" type="image/icon type">

  <div class="navbar">
    <div class="logo">
      <h3 class="logo"><a class="logo" href="admin-home.jsp">In Taberna</a></h3>
    </div>

    <div class="search">
      <form action="" method="get" id="searchAlbum" class="search">
        <input type="search" name="search" id="searchBar" onkeyup="showResult(this.value)" autocomplete="off" size="20">
      </form>
    </div>

    <div class="buttons">
      <ul class="buttons">
        <li class="buttons"><a class="buttons" href="../../chart">🛒</a></li>
        <li class="buttons"><a class="buttons" href="login.jsp">Log-In</a></li>
        <li class="buttons"><a class="buttons" href="help.jsp">Help</a></li>
      </ul>
    </div>
  </div>

  <!-- Metodo per eseguire la ricerca live -->
  <script>
    function showResult(str) {
      if (str.length==0) {
        $(".result").hide();
        $(".main").fadeIn();
        return;
      }
      var xmlhttp=new XMLHttpRequest();
      xmlhttp.onreadystatechange=function() {
        if (this.readyState==4 && this.status==200) {
          var obj = JSON.parse(this.responseText);
          $(".main").fadeOut();
          $(".result").show();
          var str = "<img style=\"width:400px; height: 400px\" src=\"../../getPicture?id="+ obj[0].name+ "\">" + "<h3>" + obj[0].name +"</h3> <p>" +obj[0].prezzo +"$</p>" + "<form action='../../addSession' style='display: inline'><input style='background-color: limegreen; border-radius: 10px' type='submit' value='Aggiungi al carrello'><input type='hidden' name='albumName' value='"+obj[0].name+"\'></form>";
          $(".result .content").html(str);
          $("#songList").text("");
          for(let i = 0; i<obj.length; i++){
            for(let j = 0; j < obj[i].songs.length; j++){
              $("#songList").append("<li style='float: left;'>"+obj[i].songs[j]+"</li><br>");
            }
          }

        }
      }
      xmlhttp.open("GET","../../livesearch?str="+str,true);
      xmlhttp.send();
    }
  </script>

  <style>
    .result{
      display: grid;
      width: 100%;
      grid-template-columns: 1fr 1fr;
    }

    #songList{
      background-color: whitesmoke;
    }

    @media screen and (max-width: 900px) {
      .result {
        display: block;
      }

      #songList{
        padding: 0%;
      }
    }
  </style>
</head>

<body>
<script>
  $(document).ready(function(){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
      if (this.readyState==4 && this.status==200) {
        const obj = JSON.parse(this.responseText);
        for (let i = 0; i < obj.length; i++){
          $("#userList ul").append("<li>"+ obj[i].name +
                  "<form action=\"../../updateUser\">"+
                    "<input type=\"hidden\" name=\"id\" value=\""+obj[i].name+"\">" +
                    "<input type=\"submit\" value=\"Modifica\">"+
                  "<input type=\"submit\" formaction=\"../../deleteUser\" value=\"Cancella\">"
                  +"</form>" + "</li>");
        }
      }
    }
    xmlhttp.open("GET","../../getUser",true);
    xmlhttp.send();
  })

  $(document).ready(function(){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
      if (this.readyState==4 && this.status==200) {
        const obj = JSON.parse(this.responseText);
        for (let i = 0; i < obj.length; i++){
          $("#albumList ul").append("<li>"+ obj[i].name +
          "<form action=\"../../updateAlbum\">"+
          "<input type=\"hidden\" name=\"id\" value=\""+obj[i].name+"\">" +
          "<input type=\"submit\" value=\"Modifica\">" +
          "<input type=\"submit\" formaction=\"../../deleteAlbum\" value=\"Cancella\">"
          +"</form>" + "</li>");
        }
      }
    }
    xmlhttp.open("GET","../../getAlbum",true);
    xmlhttp.send();
  })


  $(document).ready(function(){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
      if (this.readyState==4 && this.status==200) {
        const obj = JSON.parse(this.responseText);
        for (let i = 0; i < obj.length; i++){
          $("#albumListSong ul").append("<li>"+ obj[i].name +
                  "<form action=\"showSong.jsp\">"+
                  "<input type=\"hidden\" name=\"id\" value=\""+obj[i].name+"\">" +
                  "<input type=\"submit\" value=\"Visualizza\">"
                  +"</form>" + "</li>");
        }
      }
    }
    xmlhttp.open("GET","../../getAlbum",true);
    xmlhttp.send();
  })

</script>

<div class="result">
  <div class="content">

  </div>
  <div id="songList">

  </div>
</div>





<div class="main">
  <div>
    <h3>Gestisci utenti</h3>
    <div id="userList">
      <ul>

      </ul>
    </div>
  </div>


  <div>
    <h3>Gestisci Album</h3>
    <div id="albumList">
      <ul>

      </ul>
    </div>

    <h3>Aggiungi Album</h3>
    <div id="addAlbum">
      <form action="../../addalbumservlet" method="post" enctype="multipart/form-data">
        <input type="text" name="titolo" placeholder="Titolo">
        <input type="number" name="prezzo" step="any" min=”0″ placeholder="Prezzo">
        <input type="file" name="file" placeholder="Copertina">
        <label for="homepage">homepage</label>
        <input type="checkbox" id="homepage" name="homepage">
        <input type="submit" value="Invia">
      </form>
    </div>



    <h3>Gestisci canzoni</h3>
    <h5>Visualizza Canzoni</h5>
    <div id="albumListSong">
      <ul>

      </ul>
    </div>

    <h5>Aggiungi canzone</h5>
    <form action="../../addSong">
      <input type="text" name="c_title" placeholder="Nome Canzone">
      <input type="text" name="a_title" placeholder="Nome Album">
      <input type="submit" value="Aggiungi">
    </form>

  </div>
</div>

</body>

</html>