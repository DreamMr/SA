<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Email Service</title>
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
		<div id="introduce">
			这是SA实习部分<br><br>
		</div>

		<div id="Valid" style=" width:1400px;float:left;">
			<form action="EmailServlet" method="GET">
			邮箱地址:<input type="text" name="address" style="width:750px;" />
   			 	&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Email" value="验证邮箱地址"/>
				<br> <br>
				邮件正文:<br>
				<textarea name="message" rows="20" cols="100"></textarea>
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Email" value="发送邮件"/>
			</form>
		<br>
		</div>
		<%
			String result=(String)request.getAttribute("result");
			if(result!=null)
			{%>
		<script type="text/javascript">
            alert("<%=result%>");
		</script>
		<%
			}
		%>
		
	</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
null</div>

</div>
</body>
</html>