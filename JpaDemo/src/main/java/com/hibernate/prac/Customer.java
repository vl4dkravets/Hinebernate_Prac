package com.hibernate.prac;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "custID", unique=true)
	private int id;
	
	@Column(name = "firstname", nullable=false)
	private String firstName;
	
	@Column(name = "lastname", nullable=false)
	
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	@Override
	public String toString() {
		return this.getFirstName() + " " +
				this.getLastName() + " " +
				this.getId();
	}
	
}
