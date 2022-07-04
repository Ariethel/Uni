<%@ page import="model.Album" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
       <%
           // Prendo la lista di Album che devono andare in homepage
           ArrayList<Album> list = (ArrayList<Album>) request.getServletContext().getAttribute("homepage");
       %>
    <link rel="stylesheet" type="text/css" href="resources/css/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <link href="resources/css/head.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
       <title>InTaberna - Music Store</title>
       <link rel="icon" href="resources/icons/icon.png" type="image/icon type">

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
                   <li class="buttons"><a class="buttons" href="./chart">🛒</a></li>
                   <li class="buttons"><a class="buttons" href="resources/view/login.jsp">Log-In</a></li>
                   <li class="buttons"><a class="buttons" href="resources/view/help.jsp">Help</a></li>
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
                       var str = "<img style=\"width:400px; height: 400px\" src=\"./getPicture?id="+ obj[0].name+ "\">" + "<h3>" + obj[0].name +"</h3> <p>" +obj[0].prezzo +"$</p>" + "<form action='./addSession' style='display: inline'><input style='background-color: limegreen; border-radius: 10px' type='submit' value='Aggiungi al carrello'><input type='hidden' name='albumName' value='"+obj[0].name+"\'></form>";
                       $(".result .content").html(str);
                       $("#songList").text("");
                       for(let i = 0; i<obj.length; i++){
                           for(let j = 0; j < obj[i].songs.length; j++){
                               $("#songList").append("<li style='float: left;'>"+obj[i].songs[j]+"</li><br>");
                           }
                       }

                   }
               }
               xmlhttp.open("GET","livesearch?str="+str,true);
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
<div class="result">
    <div class="content">

    </div>
    <div id="songList">

    </div>
</div>


<!-- MAIN (Center website) -->
<div class="main">
    <div class="row">
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(0).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(0).getTitolo()%></h3>
                <p><%=list.get(0).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(1).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(1).getTitolo()%></h3>
                <p><%=list.get(1).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(2).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(2).getTitolo()%></h3>
                <p><%=list.get(2).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(3).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(3).getTitolo()%></h3>
                <p><%=list.get(3).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(4).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(4).getTitolo()%></h3>
                <p><%=list.get(4).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(5).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(5).getTitolo()%></h3>
                <p><%=list.get(5).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(6).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(6).getTitolo()%></h3>
                <p><%=list.get(6).getPrezzo()%></p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%=list.get(7).getTitolo()%>" onerror="this.src='./imgs/nophoto.png'" style="width:150px; height: 150px">
                <h3><%=list.get(7).getTitolo()%></h3>
                <p><%=list.get(7).getPrezzo()%></p>
            </div>
        </div>
    </div>
</div>
    <!-- END MAIN -->
</body>
</html>