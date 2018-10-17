package com.test.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Jes on 09/28/2018.
 */

@Entity
public class Person {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String fName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", fName='" + fName + '\'' +
				'}';
	}

	public Person(Long id, String fName) {
		this.id = id;
		this.fName = fName;
	}

	public Person(){

	}
}
