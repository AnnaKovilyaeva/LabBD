package com.mmsp;

import com.mmsp.model.Product;
import com.mmsp.model.Requisition;
import com.mmsp.dao.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Выгрузка в ХТМЛ всех реквизитов
 * @author Алексей
 */
public class RequRoom extends HttpServlet {

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
		pw.println("<TITLE>Requisition List</TITLE>");
		pw.println("</HEAD>");
		pw.println("<BODY>");

		DAO<Requisition> dao_requ = new DAO<>();
		List<Requisition> liRequ = dao_requ.getAll(new Requisition());
		if (liRequ.size() != 0) {

			pw.println("<table align=\"center\">");
			pw.println("<tr>");
			pw.println("<th>");
			pw.println("ID User");
			pw.println("</th>");
			pw.println("<th>");
			pw.println("List Product");
			pw.println("</th>");
			pw.println("</tr>");

			for (Requisition u : liRequ) {
				pw.println("<tr>");
				pw.println("<td>");
				pw.println(u.getUserd().getId());
				pw.println("</td>");
				pw.println("<td>");
				for (Product p : u.getProducts()) {
					pw.println(p.getProdName() + "<br>");
				}
				pw.println("</td>");
				pw.println("<td>");
				pw.println("<a href=\"requDel?id=" + u.getId() + "\">DELETE(Not supported yet)</a>");
				pw.println("</td>");			
				pw.println("</tr>");
			}
			pw.println("</table>");
		} else {
			pw.println("<br>Requisition not found!");
		}

		pw.println("<a href=\"userRoom\" align=\"center\">UserRoom</a>");
		pw.println("<a href=\"prodRoom\" align=\"center\">ProductRoom</a>");
		pw.println("</BODY>");
		pw.println("</HTML>");
	}
}
