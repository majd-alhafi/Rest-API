package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DepartmentCourseDTO;
import com.example.demo.models.Course;
import com.example.demo.repositories.CoursesRepo;

@Service
public class CourseServices {
	@Autowired
	CoursesRepo courseRepo;
	
	private DepartmentCourseDTO convertDataIntoDTO(Course course) {
		DepartmentCourseDTO departmentCourseDTO = new DepartmentCourseDTO();
		departmentCourseDTO.setCourseName(course.getName());
		departmentCourseDTO.setDepartmentName(course.getDepartment().getName());
		return departmentCourseDTO;
	}
	
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
	
	public List<DepartmentCourseDTO> getAllCoursesDepartment(){
		return courseRepo.findAll()
				.stream()
				.map(this::convertDataIntoDTO)
				.collect(Collectors.toList());
	}
}
