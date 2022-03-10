<%@ page import="model.HeaderBean" %>
<%@ page import="controller.ServletRequestHeaders" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Showing your request headers</title>
</head>
<body>
<%
    HeaderBean headerBean = (HeaderBean) request.getAttribute("headers");
%>
<%for (int i = 0; i < headerBean.getHeaderNames().size(); i++){%>
<%= headerBean.getHeaderNames().get(i)%>
<%= headerBean.getHeaderValues().get(i)%> <br>

<%}%>
</body>
</html>
