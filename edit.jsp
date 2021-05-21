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
<h1><b><center>Edit Details</center></b></h1>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:forEach items="${sessionScope.editlist}" var="a">
<c:set value="${a.id}" var="x"></c:set>
<c:set value="${a.fn}" var="y"></c:set>
<c:set value="${a.ln}" var="y1"></c:set>
<c:set value="${a.un}" var="z"></c:set>
<c:set value="${a.pn}" var="w"></c:set>
</c:forEach>

<form action="<%=request.getContextPath()%>/regcontroller" method="post">
first name :<input type="text" name="fn" value="${y}" class="form-control"><br>
last name :<input type="text" name="ln" value="${y1}"class="form-control"><br>
user name :<input type="text" name="un" value="${z}"class="form-control"><br>
password :<input type="text" name="pn" value="${w}"class="form-control"><br>
<input type="hidden" value="update" name="flag">
<input type="submit" class="btn btn-success">
</body>
</html>