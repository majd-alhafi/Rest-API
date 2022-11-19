package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Course;

@Repository
public interface CoursesRepo extends JpaRepository<Course,Integer>{
	public List<Course> findByDepartmentId(Integer id);
}
