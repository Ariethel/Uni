<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #navlist{
        overflow: hidden;
        background-color: #0c6540;
        width: 100%;
        position: absolute;
        align-items: center;
    }

    #navlist #home-button{
        float: left;
    }

    #navlist #home-button:hover{
        background-color: #0c6540;
    }

    .search-bar{
        float: none;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    ul{
        float: right;
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
    }

    li {
        float: right;
    }

    li a {
        display: flex;
        color:black;
        padding: 8px;
        margin: 0px;
        text-align: center;
        background-color: #f1f5f4;
    }

    #navlist a:hover{
        background-color: #dad7cd;
        text-decoration: none;
        color: black;
    }
</style>


<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Navbar items -->
    <div id="navlist">
        <!-- website logo -->
        <a id="home-button" href="./index.jsp">
            <img src = "./images/logo.png" alt = "InTaberna Logo" height="64px" width="64px"/>
        </a>

        <!-- search bar right align -->
        <div class="search-bar">
            <form action="#">
                <input type="search" placeholder=" Search Album" name="search">
            </form>
        </div>

        <!-- Buttons -->
        <ul>
            <li><a href="#">🛒</a></li>
            <li><a href="./WEB-INF/view/login.jsp">Log-In</a></li>
            <li><a href="#">Help</a></li>
        </ul>

    </div>

</head>
<body>

</body>
</html>
