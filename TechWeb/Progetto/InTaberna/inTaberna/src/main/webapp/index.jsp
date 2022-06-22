<%@ page import="model.Album" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/view/head.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="resources/css/index.css">
</head>
<body>
<%--<form method="get" action="fillhomeservlet"></form>--%>
<%
    // Prendo la lista di Album che devono andare in homepage
    ArrayList<Album> list = (ArrayList<Album>) request.getServletContext().getAttribute("homepage");
%>
<!-- MAIN (Center website) -->
<div class="main">
    <div class="row">
        <div class="column">
            <div class="content">
                <img src="./getPicture?id=<%list.get(0).getTitolo();%>" onerror="this.src='./imgs/nophoto.png'" <%--style="width:100px"--%>>
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="lights.jpg" alt="Lights" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="nature.jpg" alt="Nature" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="mountains.jpg" alt="Mountains" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="lights.jpg" alt="Lights" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="lights.jpg" alt="Lights" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="lights.jpg" alt="Lights" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
        <div class="column">
            <div class="content">
                <img src="lights.jpg" alt="Lights" style="width:100%">
                <h3>My Work</h3>
                <p>Lorem ipsum..</p>
            </div>
        </div>
    </div>
</div>
    <!-- END MAIN -->
</body>
</html>