package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Department;
import com.example.demo.services.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService deparmentService;
	
	@GetMapping("/departments")
	public List<Department> getAllDeparments() {
		return deparmentService.getAllDepartments();
	}
		
	@GetMapping("/department/{id}")
	@ResponseBody
	public Optional<Department> getEmployeesById(@PathVariable Integer id) {
	    return deparmentService.getDeparment(id);
	}
	
	@PostMapping("/add-department")
	public void addNewDepatment(@RequestBody Department newDepartment) {
		deparmentService.addDepartment(newDepartment);
	}
	
	@PutMapping("/department/{id}")
	public void updateDepartment(@PathVariable Integer id,@RequestBody Department newDepartment) {
		deparmentService.updateDepartment(id,newDepartment);
	}
	
	@DeleteMapping("/department/{id}")
	public void deleteDepartment(@PathVariable Integer id) {
		deparmentService.deleteDepartment(id);
	}
}
