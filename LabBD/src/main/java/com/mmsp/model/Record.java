package com.mmsp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Record {

	@Column(name="RECORD_ID_PRODUCT")
	private Long idProd;

	@Column(name="RCORD_PRODUCT_COUNT")
	private int count;

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
