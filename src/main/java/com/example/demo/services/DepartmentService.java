package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Department;
import com.example.demo.repositories.DepermentRepo;

@Service
public class DepartmentService {
	@Autowired
	DepermentRepo departmentRepo;
	
	public List<Department> getAllDepartments(){
		return departmentRepo.findAll();
	}
	
	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Optional<Department> getDeparment(Integer id) {
		return departmentRepo.findById(id);
	}

	public void updateDepartment(Integer id, Department newDepartment) {
		Department tempDepartment = getDeparment(id).get();
		if (tempDepartment != null) {
			tempDepartment.setName(newDepartment.getName());
			addDepartment(tempDepartment);
		}	
	}

	public void deleteDepartment(Integer id) {
		departmentRepo.deleteById(id);
	}
}
