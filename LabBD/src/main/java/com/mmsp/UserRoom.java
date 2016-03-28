package com.mmsp;

import com.mmsp.model.Userd;
import com.mmsp.dao.DAO;
import com.mmsp.util.Logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRoom extends HttpServlet {

	private static final long serialVersionUID = 3445444525973535612L;
	
	Logic core = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		core = new Logic();
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
		pw.println("<TITLE>User List</TITLE>");
		pw.println("</HEAD>");
		pw.println("<BODY>");

		DAO<Userd> dao_User = new DAO<Userd>();
		List<Userd> liUser = dao_User.getAll(new Userd());
		if (liUser.size() != 0) {
			
			pw.println("<table align=\"center\">");
			pw.println("<tr>");
			pw.println("<th>");
			pw.println("LastName");
			pw.println("</th>");
			pw.println("<th>");
			pw.println("FirstName");
			pw.println("</th>");
			pw.println("<th>");
			pw.println("MiddleName");
			pw.println("</th>");
			pw.println("</tr>");
			
			for (Userd u : liUser) {
				pw.println("<tr>");
				pw.println("<td>");
				pw.println(u.getLastName());
				pw.println("</td>");
				pw.println("<td>");
				pw.println(u.getFirstName());
				pw.println("</td>");
				pw.println("<td>");
				pw.println(u.getMiddleName());
				pw.println("</td>");
				pw.println("<td>");
				pw.println("<a href=\"userAdd.html?id=" + u.getId() + "&lastName=" + u.getLastName() + "&firstName=" + u.getFirstName() + "&middleName=" + u.getMiddleName() + "\">UPDATE</a>");
				pw.println("</td>");
				pw.println("<td>");
				pw.println("<a href=\"userDel?id=" + u.getId() + "\">DELETE</a>");
				pw.println("</td>");			
				pw.println("</tr>");
			}
			pw.println("</table>");
		} else {
			pw.println("<br>User not found!");
		}

		pw.println("<a href=\"userAdd.html\" align=\"center\">Add new User</a>");
		pw.println("</BODY>");
		pw.println("</HTML>");
	}
}
