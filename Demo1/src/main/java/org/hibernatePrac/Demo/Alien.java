package org.hibernatePrac.Demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="alien")
@Table (name="aliens_table")
public class Alien {
	
	@Id
	private int id;
	
	private AlienName name;
	
	@Column(name="alien_color")
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AlienName getName() {
		return name;
	}
	public void setName(AlienName name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
	
	
	

}
