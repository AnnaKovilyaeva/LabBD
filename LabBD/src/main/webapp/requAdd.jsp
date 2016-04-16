<%@page import="com.mmsp.model.Requisition"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Requisition ADD</title>
	</head>
	<body>
	<%
		com.mmsp.dao.DAO<com.mmsp.model.Product> dao_prod = new com.mmsp.dao.DAO<>();
		java.util.List<com.mmsp.model.Product> liProd = dao_prod.getAll(new com.mmsp.model.Product());
		if (liProd.size() != 0) {
			out.println("<form action=\"requAdd\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"id\" value=\""+ request.getParameter("id") +"\"/>");
	
			out.println("Select Product:<br>");
			out.println("<select size = \"5\" multiple name = \"requs\">");
	
			for (com.mmsp.model.Product p : liProd) {
				out.println("<option value = \"" + p.getId() + "\">" + p.getProdName() + "</option>");
			}
	
			out.println("</select><br>");
			out.println("<input type=\"submit\" name=\"Submit\">");
			out.println("</form>");
		} else {
			out.println("Product not Found. Add product before add requisition");
		}
	
	%>
	</body>
</html>