package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Userd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUpd extends HttpServlet {

	private static final long serialVersionUID = 7151812311221083364L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		DAO<Userd> dao_User = new DAO<Userd>();
		Userd u = dao_User.getById(new Userd(), Long.valueOf(req.getParameter("id")));
		PrintWriter pw = resp.getWriter();
		pw.println("<html>"
			+ "<head>"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
			+ "<title>Update User</title>"
			+ "</head>"
			+ "<body>"
			+ "<h1>Update User</h1>");

		pw.println("<form method = \"POST\">");
		pw.println("<br>Last Name:");
		pw.println("<input type=\"text\" name=\"lastName\" value=\"" + u.getLastName() + "\" />");
		pw.println("<br>First Name:");
		pw.println("<input type=\"text\" name=\"firstName\" value=\"" + u.getFirstName() + "\" />");
		pw.println("<br>Middle Name:");
		pw.println("<input type=\"text\" name=\"middleName\" value=\"" + u.getMiddleName() + "\" />");
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
		resp.sendRedirect("userRoom");
	}

}
