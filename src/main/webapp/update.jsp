<%@page import="dto.book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% book b = (book)request.getAttribute("bro"); %>
	<h1>ENTER BOOK DETAILS</h1>
	<form action="update" method="get">
	
	BOOK ID :<input type="number" name="id" value="<%=b.getId()%>"><br><br>
	BOOK NAME :<input type="text" name="name" value="<%=b.getName()%>"><br><br>
	BOOK AUTHOR :<input type="text" name="author" value="<%=b.getAuthor()%>"><br><br>
	BOOK PRICE :<input type="number" name="price" value="<%=b.getPrice()%>"><br><br>
	BOOK TOTALPAGES :<input type="number" name="totalpages" value="<%=b.getTotalpages()%>"><br><br>
	<input type="submit" value="update">
	
	
	</form>
</body>
</html>