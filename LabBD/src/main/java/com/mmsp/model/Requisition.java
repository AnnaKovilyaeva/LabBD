package com.mmsp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name = "REQUISITION_COUNT")
    private Integer requCount; // Количество заказываемового товара
	
	@ManyToOne
	@JoinColumn(name = "USERD_ID")
	private Userd userd;
	
	@OneToMany(mappedBy = "requistion")
	private Set<Product> products = new HashSet<Product>();
}
