package com.example.demo.models;



//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	/*@OneToMany(fetch = FetchType.EAGER)
	List<Course> courses = new ArrayList<Course>();*/
	public Department() {
		super();
	}
	
	public Department(Integer id, String name){//, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		//this.courses = courses;
	}
	/*public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}*/

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
	
}
