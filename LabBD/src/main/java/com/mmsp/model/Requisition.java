package com.mmsp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.mmsp.util.HibernateUtil;

// CASCADE STYLE // https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/engine/CascadeStyle.html

@Entity
@Table(name = "REQUISITION")
public class Requisition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REQUISITION_ID")
	private Long id;

	@Column(name = "REQUISITION_USER_ID")
	private Long userId; // ID Узер, который заказ сделал

	@ElementCollection
	@CollectionTable(name = "RECORDS", joinColumns = @JoinColumn(name="REQUISITION_RECORD_ID"))
		@AttributeOverrides({
			@AttributeOverride(name = "idProd", column = @Column(name="fid_Prod")),
			@AttributeOverride(name = "count", column = @Column(name="fcount_Prod"))
		})
	private Set<Record> products = new HashSet<>();

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<Record> getProducts() { // UNDONE Lazy Init
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Set<Record> setProd = null;
		try {
			Hibernate.initialize(.getFaqAnswers());

			session.commit();
			faqQuestions.getFaqAnswers().size();
		} finally {
			session.close();
		}*/
		return products;
	}

	public void setProducts(Set<Record> products) {
		this.products = products;
	}
}
