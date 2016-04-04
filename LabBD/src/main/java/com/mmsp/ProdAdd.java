package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Product;
import com.mmsp.model.Userd;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdAdd extends HttpServlet implements SingleThreadModel {

	private static final long serialVersionUID = -5194851994417726484L;
	private String pN;
	private String pC;
	private String sId;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		sId = request.getParameter("id");
		pN = request.getParameter("prodName");
		pC = request.getParameter("prodCount");
		doIt(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sId = request.getParameter("id");
		pN = request.getParameter("prodName");
		pC = request.getParameter("prodCount");

		doIt(request, response);
	}

	private void doIt(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setStatus(200);
		DAO<Product> dao_Prod = new DAO<>();
		try {
			if (sId != null && !sId.equals("null") && !sId.equals("")) {
				dao_Prod.update(new Product(Long.valueOf(sId), pN, Integer.parseInt(pC)));
			} else {
				dao_Prod.add(new Product(pN, Integer.parseInt(pC)));	
			}
		} catch (java.lang.NumberFormatException ex) {
			// какой-то мудила ввёл не цифру, а букву
			ex.printStackTrace();
		}
		response.sendRedirect("prodRoom");
	}
}
