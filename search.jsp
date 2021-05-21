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
<h1><b><center>Registered Details</center></b></h1>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table border="2px" align="center">
<br>
 <tr>
 <th>ID</th>
 <th>First Name</th>
 <th>Last Name</th>
 <th>User Name</th>
 <th>Password</th>
 <th>action</th>
 </tr>
 <c:forEach items="${sessionScope.list}" var="a">
 <tr>
 <td>${a.id}</td>
 <td>${a.fn}</td>
 <td>${a.ln}</td>
 <td>${a.un}</td>
 <td>${a.pn}</td>
 <td><a href ="<%=request.getContextPath()%>/regcontroller?id_delete=${a.id}&flag=delete">delete</a>
 <a href ="<%=request.getContextPath()%>/regcontroller?id_edit=${a.id}&flag=edit">edit..</a>
 
   </td>
 </tr> 
 </c:forEach>
 
</table>
<center><a href ="forgot.jsp">want to change password?</a></center>
</body>
</html>