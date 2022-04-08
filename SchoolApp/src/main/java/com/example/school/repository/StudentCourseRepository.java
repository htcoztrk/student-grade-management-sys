package com.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.entity.StudentCourse;
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>{

}
