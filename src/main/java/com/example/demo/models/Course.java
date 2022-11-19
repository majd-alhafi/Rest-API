package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer id;
	@Column(name = "name")
	private String name;	
	@Column(name = "credits")
	private Integer credits;
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Course() {
		super();
	}
	
	
	public Course(Integer id, String name, Integer credits, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.department = department;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
}
