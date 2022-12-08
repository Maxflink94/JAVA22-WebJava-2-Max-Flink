<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>

	<%
	if(session.getAttribute("isLoggedIn") != null){
		Bean loginBean = (Bean) session.getAttribute("isLoggedIn");
		out.print("<h2> Welcome to your profile, " + loginBean.getUsername() + "</h2>") ;
		out.print("<form action=\"" + request.getContextPath() + "/RemoveController\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"LogOut\" />");
		out.print("</form>");
	} else {
		response.sendRedirect("index.jsp");
	}
		
	%>

</body>
</html>