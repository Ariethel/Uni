<%@ page import="model.Album" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/view/head.jsp"></jsp:include>
</head>
<body>
    <%--<div class="home-album">
        <!-- Come chiamo la servlet per caricare gli album? Provo con questo script ajax-->
        <script>
            asyncRequest = new XMLHttpRequest();
            asyncRequest.open('GET', '/fillhomeservlet', true);
        </script>
        <!--Copertina album, con sotto Titolo e prezzo-->
        <%
            // retrieve your list from the request, with casting
            ArrayList<Album> homepage = (ArrayList<Album>) request.getAttribute("homepage");

            // print the information about every category of the list
            for(Album a : homepage)
            {
                // codice html per stampare gli album nella home

            }
        %>
    </div>--%>
</body>
</html>