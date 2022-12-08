<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/Controller" method="POST">
	<input name="username" type="text" placeholder="Username" >
	<p></p>
	<input name="password" type="password" placeholder="Password">
	<p></p>
	<input type="submit" value="Login">
</form>

${message}

</body>
</html>