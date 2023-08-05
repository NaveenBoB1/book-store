<%@page import="dto.book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="color: black;">
	<h1>BOOK TABLE</h1>
	<table border="5px" cellspacing="10px" cellpading="5px">
	
	<tr>
	
	<th>ID</th>
	<th>NAME</th>
	<th>AUTHOR</th>
	<th>PRICE</th>
	<th>TOTALPAGES</th>
	<th>DELETE</th>
	<th>UPDATE</th>
	</tr>
	 
	 <% ArrayList<book> al =(ArrayList)request.getAttribute("data"); %>
	 <% for(book b : al) {%>
	 <tr> 
	 <td><%= b.getId()%></td>
	 <td><%= b.getName()%></td>
	 <td><%= b.getAuthor() %> </td>
	 <td><%= b.getPrice() %></td>
	 <td><%= b.getTotalpages()%></td>
	<td><a href="delete?id=<%=b.getId()%>">delete</a></td>
	<td><a href="edit?id=<%=b.getId()%>">edit</a></td> 
	 </tr>
	 <%} %>
	</table>
</body>
</html>