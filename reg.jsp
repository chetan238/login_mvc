<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container ml-5">


<form action="<%=request.getContextPath()%>/regcontroller" method="post">
<br>
<h1><b><center>Register Your Details</center></b></h1>
first name :<input type="text" name="fn" class="form-control"><br>
last name :<input type="text" name="ln" class="form-control"><br>
user name :<input type="text" name="un"class="form-control"><br>
password :<input type="text" name="pn"class="form-control" ><br>
<input type="hidden" value="insert" name="flag">
<input type="submit"class="btn btn-success">

</form>

<a href="<%=request.getContextPath()%>/regcontroller?flag=search"> see registered users !!!</a>
<br>
<b> Already Have an Account ??</b>
<br>
<a href="login.jsp"><button class="btn btn-success">Login Here</button></a>
</div>

</body>
</html>