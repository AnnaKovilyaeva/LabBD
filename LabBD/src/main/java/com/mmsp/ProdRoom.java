package com.mmsp;

import com.mmsp.model.Product;
import com.mmsp.dao.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Выгрузка в ХТМЛ всех Продуктов
 * @author Алексей
 */
public class ProdRoom extends HttpServlet {

	private static final long serialVersionUID = -2279462696209669190L;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);

		doIt(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);

		doIt(req, resp);
	}
	private void doIt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("<HTML>");
		pw.println("<HEAD>");
		pw.println("<TITLE>Product List</TITLE>");
		pw.println("</HEAD>");
		pw.println("<BODY>");

		DAO<Product> dao_Prod = new DAO<>();
		List<Product> liProd = dao_Prod.getAll(new Product());
		if (liProd.size() != 0) {
			
			pw.println("<table align=\"center\">");
			pw.println("<tr>");
			pw.println("<th>");
			pw.println("ProductName");
			pw.println("</th>");
			pw.println("<th>");
			pw.println("ProductCount");
			pw.println("</th>");
			pw.println("</tr>");
			
			for (Product u : liProd) {
				pw.println("<tr>");
				pw.println("<td>");
				pw.println(u.getProdName());
				pw.println("</td>");
				pw.println("<td>");
				pw.println(u.getProdCount());
				pw.println("</td>");
				pw.println("<td>");
				pw.println("<a href=\"productAdd.html?id=" + u.getId() + "&prodName=" + u.getProdName() + "&prodCount=" + u.getProdCount() + "\">UPDATE</a>");
				pw.println("</td>");
				pw.println("<td>");
				pw.println("<a href=\"prodDel?id=" + u.getId() + "\">DELETE</a>");
				pw.println("</td>");			
				pw.println("</tr>");
			}
			pw.println("</table>");
		} else {
			pw.println("<br>Product not found!");
		}

		pw.println("<a href=\"productAdd.html\" align=\"center\">Add new Product</a>");
		pw.println("<a href=\"userRoom\" align=\"center\">UserRoom</a>");
		pw.println("<a href=\"requRoom\" align=\"center\">RequisitionRoom</a>");
		pw.println("</BODY>");
		pw.println("</HTML>");
	}
}
