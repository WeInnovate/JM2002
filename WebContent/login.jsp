<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="login-servlet" method="post">

		<h1>Login!</h1>
		<table>
		${requestScope.msg }
		<%-- <%
		String msg = request.getAttribute("msg").toString();
		
			out.print(msg);
		
		%> --%>
			<tr>
				<td>User Name</td>
				<td><input type="text" placeholder="Enter username here" name="un" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" placeholder="Enter password here" name="pass" /></td>
			</tr>
			<tr>
				<td b><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>




	</form>

</body>
</html>