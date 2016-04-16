package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Product;
import com.mmsp.model.Requisition;
import com.mmsp.model.Userd;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequAdd extends HttpServlet implements SingleThreadModel {

	private static final long serialVersionUID = -5194851994417726484L;
	private String[] arProd;
	private String sId;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		sId = request.getParameter("id");
		arProd = request.getParameterValues("requs");
		doIt(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sId = request.getParameter("id");
		arProd = request.getParameterValues("requs");
		System.err.println("Length == " + request.getParameterValues("requs").length);
		doIt(request, response);
	}

	private void doIt(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setStatus(200);
		System.err.println("id Userd == " + sId);
		for (String s : arProd) {
			System.err.println("id Product == " + s);
		}

		DAO<Requisition> dao_requ = new DAO<>();
		DAO<Userd> dao_user = new DAO<>();
		DAO<Product> dao_prod = new DAO<>();
		Requisition r = new Requisition();
		Userd ud = dao_user.getById(new Userd(), Long.valueOf(sId));
		ud.getRequisitions().add(r);
		dao_user.update(ud);
		r.setUserd(ud);
		r.setId(dao_requ.add(r));
		for (String s : arProd) {
			Product p = dao_prod.getById(new Product(), Long.valueOf(s));
			p.setRequistion(r);
			dao_prod.update(p);
			r.addProducts(p);
		}

		System.err.println("Requisition was added with ID == " + r.getId());
		for (Product p : r.getProducts()) {
			System.err.println("prod name == " + p.getProdName());
		}

		response.sendRedirect("requRoom");
	}
}
