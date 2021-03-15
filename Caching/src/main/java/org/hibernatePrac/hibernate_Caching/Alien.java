package org.hibernatePrac.hibernate_Caching;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table (name="alien_table")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	
	public Alien() {}
	
	public Alien(int aid, String color, String aname) {
		this.aid = aid;
		this.color = color;
		this.aname = aname;
	}

	@Id
	private int aid;
	private String color;
	private String aname;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", color=" + color + ", aname=" + aname + "]";
	}
	
	
	
	
	

}
