<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<h1><b><center>Login Page</center></b></h1>
<div class="container ml-5">
<form action="<%=request.getContextPath()%>/regcontroller" method="post">
User ID :<input type="text" name="uname" class="form-control"><br>
Password :<input type="text" name="pname" class="form-control"><br>
<input type="hidden" value="login" name="flag">

<input type="submit" value="login" class="btn btn-success"><br>

</form>
<b>Forget Password ?</b>
<a href="forgot.jsp"><button class="btn btn-success">Click Here</button></button></a>
<%
String s=(String)session.getAttribute("error");
if(s!=null)
{
   out.println(s);
   session.invalidate();
}
%>


</body>
</html>