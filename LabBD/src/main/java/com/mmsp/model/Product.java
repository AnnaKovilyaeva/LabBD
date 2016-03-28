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

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

	@Column(name = "PRODUCT_NAME")
    private String prodName; // Имя товара
	
	@Column(name = "PRODUCT_COUNT")
    private Integer prodCount; // Количество товара
	
	@ManyToOne
	@JoinColumn(name = "REQUISITION_ID")
	private Requisition requistion;
}
