<%--
  Created by IntelliJ IDEA.
  User: amnesia
  Date: 25/06/22
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Song</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<script>
    $(document).ready(function(){
        const params = new URLSearchParams(window.location.search);
        const name = params.get("id");
        var xmlhttp=new XMLHttpRequest();
        xmlhttp.onreadystatechange=function() {
            if (this.readyState==4 && this.status==200) {
                const obj = JSON.parse(this.responseText);
                for (let i = 0; i < obj.length; i++){
                    $("#songList ul").append("<li>"+ obj[i].name + "</li>");
                }
            }
        }
        xmlhttp.open("GET","../../getSong?id="+name,true);
        xmlhttp.send();
    })
</script>


<div id="songList">
    <ul>

    </ul>
</div>
</body>
</html>
