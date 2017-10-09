<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, java.sql.*" %>
    <%@ page errorPage="my-error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Directive</title>
</head>
<body>
<%
List<String> fruitList = new ArrayList<String>();
 fruitList.add("Apple");
fruitList.add("Pine Apple");
fruitList.add("Guava"); 

/* fruitList.add(1, "Apple");
fruitList.add(2, "Pine Apple");
fruitList.add(3, "Guava"); */

int i = 10/0;

%>

<%= fruitList %>
</body>
</html>