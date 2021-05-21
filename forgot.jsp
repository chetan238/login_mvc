<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container ml-5">
<h1><b><center>Change Password</center></b></h1>
<form action="<%=request.getContextPath()%>/regcontroller" method="post">

Enter User ID :<input type="text" name="username" class="form-control"><br><br>
enter new password :<input type="text" name="newpswd"class="form-control"><br><br>
confirm new password :<input type="text" name="cnnewpswd"class="form-control">
<input type="hidden" value="forgot" name="flag">
<br><br>

<input type="submit" class="btn btn-success">
<%
String s=(String)session.getAttribute("error");
String s1=(String)session.getAttribute("error1");
//System.out.println(s1);
if(s!=null)
{
   out.println(s);
   session.invalidate();
}

if(s1!=null)
{
   out.println(s1);
   session.invalidate();
}



%>
</form>
</div>

</body>
</html>