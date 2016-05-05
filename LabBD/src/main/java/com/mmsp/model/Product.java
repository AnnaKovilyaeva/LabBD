package com.mmsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	public Product() {
		this(null, null, 0);
	}

	public Product(Long id) {
		this(id, null, 0);
	}

	public Product(String pN, int pC) {
		this(null, pN, pC);
	}

	public Product(Long lVal, String pN, int pC) {
		super();
		this.id = lVal;
		this.prodCount = pC;
		this.prodName = pN;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long id;

	@Column(name = "PRODUCT_NAME")
	private String prodName; // Имя товара

	@Column(name = "PRODUCT_COUNT")
	private Integer prodCount; // Количество товара

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Integer getProdCount() {
		return prodCount;
	}

	public void setProdCount(Integer prodCount) {
		this.prodCount = prodCount;
	}
}
