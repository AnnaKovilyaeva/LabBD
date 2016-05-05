<%@page import="com.mmsp.model.Product"%>
<%@page import="com.mmsp.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>REQUISITION ADD</title>
	</head>
	<body>
	<%
		out.println("<form action=\"requAdd\" method=\"get\">");
		out.println("<input type=\"hidden\" name=\"id\" value=\"" + request.getParameter("id") + "\"/>"); // тут будет содержаться USER_ID
		out.println("<input type=\"hidden\" name=\"prod\" value=\"" + request.getParameter("requ") + "\"/>"); // тут будет содержаться PROD_ID

		DAO<Product> dao_prod = new DAO<>();
		Product p = dao_prod.getById(new Product(), Long.valueOf(request.getParameter("requ")));
		out.println("Product Name: " + p.getProdName() + "<br>Enter Count:<br>");

		out.println("<input type=\"text\" name=\"count\" value=\"\"/>"); // тут будет содержаться count

		out.println("<input type=\"submit\" name=\"Submit\">");
		out.println("</form>");
	%>
	</body>
</html>