package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Userd;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAdd extends HttpServlet implements SingleThreadModel {

	private static final long serialVersionUID = -5194851994417726484L;
	private String fN;
	private String lN;
	private String mN;
	private String sId;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		sId = request.getParameter("id");
		fN = request.getParameter("firstName");
		lN = request.getParameter("lastName");
		mN = request.getParameter("middleName");
		doIt(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sId = request.getParameter("id");
		fN = request.getParameter("firstName");
		lN = request.getParameter("lastName");
		mN = request.getParameter("middleName");

		doIt(request, response);
	}

	private void doIt(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//response.setStatus(200);
		DAO<Userd> dao_User = new DAO<Userd>();
		//System.err.println("id == " + sId);
		//System.err.println("fN == " + fN);
		if (sId != null && !sId.equals("null") && !sId.equals("")) {
			dao_User.update(new Userd(Long.valueOf(sId), fN, lN, mN));
		} else {
			dao_User.add(new Userd(fN, lN, mN));	
		}
		response.sendRedirect("userRoom");
	}
}
