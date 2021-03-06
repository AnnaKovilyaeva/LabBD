package com.mmsp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERD")
public class Userd {

	public Userd() {
		this(null, null, null, null);
	}

	public Userd(String fN, String lN, String mN) {
		this(null, fN, lN, mN);
	}

	public Userd(Long id2) {
		this(id2, null, null, null);
	}

	public Userd(Long id, String fN, String lN, String mN) {
		this.id = id;
		this.firstName = fN;
		this.lastName = lN;
		this.middleName = mN;
		//this.Requisitions = null;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERD_ID")
	private Long id;

	@Column(name = "USERD_FIRST_NAME")
	private String firstName; // Имя

	@Column(name = "USERD_LAST_NAME")
	private String lastName; // Фамилия

	@Column(name = "USERD_MIDDLE_NAME")
	private String middleName; // Отчество

	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "userd")
	//private Set<Requisition> Requisitions = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/*public Set<Requisition> getRequisitions() {
		return Requisitions;
	}

	public void setRequisitions(Set<Requisition> requisitions) {
		Requisitions = requisitions;
	}*/
}
