package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DepartmentCourseDTO;
import com.example.demo.models.Course;
import com.example.demo.services.CourseServices;

@RestController
public class CourseController {
	@Autowired
	CourseServices courseServices;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseServices.getAllCourses();
	}
	
	@GetMapping("/courses-department")
	public List<DepartmentCourseDTO> getAllCoursesDepartment() {
		return courseServices.getAllCoursesDepartment();
	}
	
	@GetMapping("/department/{id}/courses")
	@ResponseBody
	public List<Course> getEmployeesById(@PathVariable Integer id) {
	    return courseServices.getCoursesByDeparmentId(id);
	}
	
	@PostMapping("/add-course")
	public void addNewDepatment(@RequestBody Course newCourse) {
		courseServices.addCourse(newCourse);
	}
	
	@PutMapping("/course/{id}")
	public void updateCourse(@PathVariable Integer id,@RequestBody Course newCourse) {
		courseServices.updateCourse(id,newCourse);
	}
	
	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courseServices.deleteCourse(id);
	}
}
