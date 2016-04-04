package com.mmsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsp.util.Logic;

/**
 * Просто инициализация БД и перенаправление пользователя на выбранную им страницу
 * @author Алексей
 */
public class InitHibernate extends HttpServlet {

	private static final long serialVersionUID = -2639534234745632630L;

	public Logic core = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		core = new Logic();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sVal = req.getParameter("href");
		resp.sendRedirect(sVal);
	}
}
