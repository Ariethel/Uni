<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expert Response</title>
</head>
<body>
<h1 align="center">Beer Recommendations</h1>
<p>
    <%
        ArrayList<String> styles = (ArrayList<String>) request.getAttribute("style");
        Iterator it = styles.iterator();
        while(it.hasNext()){
            out.println("<br>Try:" + it.next());
        }
    %>
</p>


</body>
</html>
