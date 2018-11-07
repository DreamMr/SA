<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="container" style="width:1500px">
    <div id="header" style="background-color:#FFA500;">
        <h1 style="margin-bottom:0;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sa实习</h1>
    </div>
    <div id="menu" style="background-color:#FFD700;height:600px;width:100px;float:left">
        <b>菜单</b><br>
        <a href="Email.jsp">第三次作业</a>
    </div>
    <div id="content" style="background-color:#EEEEEE;height:600px;width:1400px;float:left;">
        <%
            String res=(String)request.getAttribute("result");
        %>
        <%=res %>
    </div>
    <div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
        null</div>

</div>
</body>
</html>