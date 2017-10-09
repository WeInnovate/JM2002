<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learn Scripting tags</title>
</head>
<body>
<%
int sum = 10 + 20;

int total = calSum(sum, 70);
%>
<%= total %>
<%!

int globalValue = 100;

public int calSum(int a, int b){
	return a+b+globalValue;
}

%>
</body>
</html>