package com.mmsp;

import com.mmsp.dao.DAO;
import com.mmsp.model.Product;
import com.mmsp.model.Requisition;
import com.mmsp.model.Userd;
import com.mmsp.model.Record;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RequAdd extends HttpServlet implements SingleThreadModel { // UNDONE

	private static final long serialVersionUID = -5194851994417726484L;
	private Long lIdProd; // ID продукта
	private int count; // Количество товара
	private Long lId; // ID User'a

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			lId = Long.valueOf(request.getParameter("id"));
			lIdProd = Long.valueOf(request.getParameter("prod"));
			count = Integer.parseInt(request.getParameter("count"));
		} catch (NumberFormatException ex) {
			System.err.println("ВСЁ НАКРЫЛОСЬ!!! AHTUNG!");
			ex.printStackTrace();
		}
		doIt(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.err.println("КТО_ТО ВОСПОЛЬЗОВАЛСЯ doPost()");
	}

	private void doIt(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setStatus(200);

		DAO<Requisition> dao_requ = new DAO<>();

		// Если пользователь с lId существует, то запомним его
		List<Requisition> liReq = dao_requ.getAll(new Requisition());
		Long i = null;
		for (Requisition rTemp : liReq) {
			if (rTemp.getUserId() == lId) {
				i = lId;
				break;
			}
		}

		// Достанем из БД существующий реквизит или создадим новый
		Requisition r = null;
		if (i != null) {
			r = dao_requ.getById(new Requisition(), i);
		} else r = new Requisition();

		r.setUserId(lId); // На всякий случай запомним

		Record rec = new Record();
		rec.setCount(count);
		rec.setIdProd(lIdProd);
		r.getProducts().add(rec);
		dao_requ.update(r);

		response.sendRedirect("requRoom");
	}
}
