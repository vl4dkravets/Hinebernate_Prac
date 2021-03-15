package org.hibernatePrac.Demo;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	private String firstName;
	private String lastName;
	private String middleNamel;
	
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
	public String getMiddleNamel() {
		return middleNamel;
	}
	public void setMiddleNamel(String middleNamel) {
		this.middleNamel = middleNamel;
	}
	
	@Override
	public String toString() {
		return "AlienName [firstName=" + firstName + ", lastName=" + lastName + ", middleNamel=" + middleNamel + "]";
	}

	
}
