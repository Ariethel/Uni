<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../css/head.css" rel="stylesheet" type="text/css"/>
    <link href="../css/login.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
    <title>InTaberna - Music Store</title>
    <link rel="icon" href="../icons/icon.png" type="image/icon type">

    <div class="navbar">
        <div class="logo">
            <h3 class="logo"><a class="logo" href="../../index.jsp">In Taberna</a></h3>
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

    <script>
        $(document).ready(function(){
            var xmlhttp=new XMLHttpRequest();
            var tot = 0;
            xmlhttp.onreadystatechange=function() {
                if (this.readyState==4 && this.status==200) {
                    const obj = JSON.parse(this.responseText);
                    $(".chartList ").text("");
                    for (let i = 0; i < obj.length; i++){
                        $(".chartList ").append("<div style='background-color: whitesmoke;padding: 10px;margin: 4%'>"+"<img style=\"width:120px; height: 120px\" src=\"../../getPicture?id="+ obj[i].name+ "\">" +"</br></br>"+"<p style='font-weight:bold'>"+ obj[i].name + "</p>"+ "<p style='font-weight:lighter'>"+ obj[i].prezzo + "</p>"+"</div>");
                         tot += obj[i].prezzo;
                    }
                    $(".total").text("");
                    $(".total").append("Totale:"+ tot.toFixed(2) + "<form method=\"get\" action=\"../../emptyChart\"><input style='background-color: limegreen; border-radius: 10px' type='submit' value='Concludi ordine'>");
                }
            }
            xmlhttp.open("GET","../../loadChart",true);
            xmlhttp.send();
        })
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

<!--Form validation-->
<script>
    function validateform(){
        var name=document.loginform.username.value;
        var password=document.loginform.password.value;

        if (name==null || name==""){
            alert("Name can't be blank");
            return false;
        }else if(password==null || password==""){
            alert("Password can't be blank");
            return false;
        }
    }
</script>


<body>
<div class="result">
    <div class="content">

    </div>
    <div id="songList">

    </div>
</div>



<div class="main">
    <div class="chartList">
    </div>

    <div class="total"></div>
</div>

</body>

</html>