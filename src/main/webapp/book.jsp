<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red;">ADD BOOK</h1><br><br>
	<form action="addbook" method="post">
	
	id :<input type="number" name="id"><br><br>
	name :<input type="text" name="name"><br><br>
	author :<input type="text" name="author"><br><br>
	price :<input type="number" name="price"><br><br>
	totalpages :<input type="number" name="totalpages"><br><br>
	<input type="submit" value="submit">
	
	</form>
</body>
</html>