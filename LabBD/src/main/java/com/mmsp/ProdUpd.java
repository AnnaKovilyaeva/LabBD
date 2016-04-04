package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdUpd extends HttpServlet {

	private static final long serialVersionUID = 7151812311221083364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		DAO<Product> dao_Prod = new DAO<>();
		Product u = dao_Prod.getById(new Product(), Long.valueOf(req.getParameter("id")));
		PrintWriter pw = resp.getWriter();
		pw.println("<html>"
			+ "<head>"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
			+ "<title>Product User</title>"
			+ "</head>"
			+ "<body>"
			+ "<h1>Product User</h1>");

		pw.println("<form method = \"POST\">");
		pw.println("<br>Product Name:");
		pw.println("<input type=\"text\" name=\"prodName\" value=\"" + u.getProdName() + "\" />");
		pw.println("<br>Count:");
		pw.println("<input type=\"text\" name=\"prodCount\" value=\"" + u.getProdCount() + "\" />");
		pw.println("<br>");
		pw.println("<input type=\"submit\" name=\"Submit\">");
		pw.println("</form>");

		pw.println("</body>"
			+ "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		resp.sendRedirect("prodRoom");
	}

}
