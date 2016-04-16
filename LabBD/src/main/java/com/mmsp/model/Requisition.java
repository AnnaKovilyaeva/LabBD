package com.mmsp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REQUISITION")
public class Requisition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REQUISITION_ID")
	private Long id;

	//@Column(name = "REQUISITION_COUNT")
	//private Integer requCount; // Количество заказываемового товара

	@ManyToOne
	@JoinColumn(name = "USERD_ID")
	private Userd userd;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "requistion")
	private Set<Product> products = new HashSet<>();

	public Requisition(Long id2) {
		this.id = id2;
	}

	public Requisition() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Integer getRequCount() {
		return requCount;
	}

	public void setRequCount(Integer requCount) {
		this.requCount = requCount;
	}*/

	public Userd getUserd() {
		return userd;
	}

	public void setUserd(Userd userd) {
		this.userd = userd;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void addProducts(Product product) {
		this.products.add(product);
	}
}
