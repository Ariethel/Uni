<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h3 class="logo"><a class="logo" href="index.jsp">In Taberna</a></h3>
        </div>

        <div class="search">
            <form action="" method="get" id="searchAlbum" class="search">
                <input type="search" name="search" id="searchBar" onkeyup="showResult(this.value)" autocomplete="off" size="20">
            </form>
        </div>

        <div class="buttons">
            <ul class="buttons">
                <li class="buttons"><a class="buttons" href="#HOME">🛒</a></li>
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
                    var str = "<img style=\"width:400px; height: 400px\" src=\"../../getPicture?id="+ obj[0].name+ "\">" + "<h3>" + obj[0].name +"</h3> <p>" +obj[0].prezzo +"$</p>";
                    $(".result .content").html(str);
                }
            }
            xmlhttp.open("GET","../../livesearch?str="+str,true);
            xmlhttp.send();
        }
    </script>
</head>

<body>
<div class="result">
    <div class="content">
        <!-- container del risultato livesearch
            Aggiungere lista canzoni appartenenti ad album
        -->

    </div>
</div>
<div class="main">
    <h1>Utente gia' presente nel database.</h1>

    <script>
        function redirect(){
            location.href = "../../index.jsp";
        }

        setTimeout(redirect,3000);

    </script>
</div>

</body>

</html>