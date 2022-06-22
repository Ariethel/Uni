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
<%
    // Prendo la lista di Album che devono andare in homepage
    ArrayList<Album> list = (ArrayList<Album>) request.getServletContext().getAttribute("homepage");
%>
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