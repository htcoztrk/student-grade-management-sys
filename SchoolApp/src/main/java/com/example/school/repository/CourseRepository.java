package com.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

	//List<Course> findByCode(String code);
}
