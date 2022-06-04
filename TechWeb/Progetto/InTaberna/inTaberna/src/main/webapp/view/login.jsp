<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../resources/css/head.css" rel="stylesheet" type="text/css"/>
    <link href="../resources/css/login.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Macondo">
    <title>InTaberna - Music Store</title>
    <link rel="icon" href="../resources/icons/icon.png" type="image/icon type">
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
<div class="navbar">
    <div class="logo">
        <h3 class="logo"><a class="logo" href="../index.jsp">In Taberna</a></h3>
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
            <li class="buttons"><a class="buttons" href="login.jsp">Log-In</a></li>
            <li class="buttons"><a class="buttons" href="help.jsp">Help</a></li>
        </ul>

    </div>
</div>

<h1 style="justify-content: center; display: flex ">Benvenuto</h1>
<div class="login">
    <form name="loginform" action="login-servlet" method="post" onsubmit="return validateform()">
        <input type="text" placeholder="username" name="username" required><br>
        <input type="password" placeholder="password" name="password" required><br>
        <input type="submit" value="Register">
        <input type="submit" value="Submit">
    </form>
</div>
</body>

</html>