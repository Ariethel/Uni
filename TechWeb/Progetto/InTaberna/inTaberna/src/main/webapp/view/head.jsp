<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/css/head.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
    <title>InTaberna - Music Store</title>
    <link rel="icon" href="resources/icons/icon.png" type="image/icon type">
</head>

<body>

<script>
    function showResult(str) {
        if (str.length==0) {
            document.getElementById("livesearch").innerHTML="";
            document.getElementById("livesearch").style.border="0px";
            return;
        }
        var xmlhttp=new XMLHttpRequest();
        xmlhttp.onreadystatechange=function() {
            if (this.readyState==4 && this.status==200) {
                document.getElementById("livesearch").innerHTML=this.responseText;
                document.getElementById("livesearch").style.border="1px solid #A5ACB2";
            }
        }
        xmlhttp.open("GET","livesearch.php?q="+str,true);
        xmlhttp.send();
    }
</script>




    <div class="navbar">
        <div class="logo">
            <h3 class="logo"><a class="logo" href="index.jsp">In Taberna</a></h3>
        </div>

        <div class="search">
            <form action="" method="get" id="searchAlbum" class="search">
                <input type="search" name="search" id="searchBar" onkeyup="showResult(this.value)" size="20">
                <div id="livesearch"></div>
                <input type="submit" class="submitButton" id="searchBtn" value="🔍">
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

</body>

</html>