package com.example.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student>  findByName(String name);
}
