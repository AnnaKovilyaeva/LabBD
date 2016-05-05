<%@page import="java.util.List"%>
<%@ page import="com.mmsp.model.Requisition"%>
<%@ page import="com.mmsp.model.Product"%>
<%@ page import="com.mmsp.model.Userd"%>
<%@ page import="com.mmsp.dao.DAO"%>
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
		DAO<Product> dao_prod = new DAO<>();
		List<Product> liProd = dao_prod.getAll(new Product());
		if (liProd.size() != 0) {
			out.println("<form action=\"requAddBefore.jsp\" method=\"get\">");
			out.println("<input type=\"hidden\" name=\"id\" value=\""+ request.getParameter("id") +"\"/>");

			out.println("Select Product:<br>");
			out.println("<select size = \"10\" name = \"requ\">");

			// UNDONE изьять список заказов, если там встречается такой id, то не показывать уже заказанные товары
			for (Product p : liProd) {
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