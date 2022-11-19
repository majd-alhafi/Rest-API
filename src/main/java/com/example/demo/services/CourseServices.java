package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Course;
import com.example.demo.repositories.CoursesRepo;

@Service
public class CourseServices {
	@Autowired
	CoursesRepo courseRepo;
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}
	public Course addCourse(Course newCourse) {
		return courseRepo.save(newCourse);
	}
	public List<Course> getCoursesByDeparmentId(Integer departmentId) {
		return courseRepo.findByDepartmentId(departmentId);
	}
	public void updateCourse(Integer id, Course newCourse) {
		Course tempCourse = courseRepo.findById(id).get();
		if (tempCourse != null) {
			tempCourse.setCredits(newCourse.getCredits());
			tempCourse.setDepartment(newCourse.getDepartment());
			tempCourse.setName(newCourse.getName());
			addCourse(tempCourse);
		}
		
	}
	public void deleteCourse(Integer id) {
		courseRepo.deleteById(id);
	}
}
