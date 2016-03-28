package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Userd;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDel extends HttpServlet implements SingleThreadModel {

	private static final long serialVersionUID = -2682608969155076466L;

	public void init(ServletConfig config) throws ServletException {
		// Блок иинциализации для загрузки БД
	}

	public void destroy() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Long id = Long.valueOf(request.getParameter("id"));
		DAO<Userd> dao_user = new DAO<Userd>();
		dao_user.remove(new Userd(id));

		response.sendRedirect("userRoom");
		//request.getRequestDispatcher("user_add.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.err.println("Должен быть вызван метод doGet!!!");
	}
}
