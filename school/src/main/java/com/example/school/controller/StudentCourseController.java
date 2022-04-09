package com.example.school.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.school.dto.request.AllStudentsGradesRequest;
import com.example.school.dto.request.StudentCourseRequest;
import com.example.school.dto.request.StudentGradesRequest;
import com.example.school.dto.response.StudentCourseResponse;
import com.example.school.dto.response.StudentGradesResponse;
import com.example.school.service.StudentCourseService;

@RestController
@RequestMapping("/studentcourse")
@CrossOrigin
@RequestScope
public class StudentCourseController {
//docker run --name school -d -p 9090:8080 school:1.0
//docker build . -t school:1.0	
	private final StudentCourseService studentCourseService;

	public StudentCourseController(StudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}
	@GetMapping("/getall")
	public List<StudentCourseResponse> getAllByPage(
			@RequestParam(required = false, defaultValue = "0") 
			@Min(0) 
			int pageNo,
			@RequestParam(required = false, defaultValue = "20") 
			@Max(50)
			int pageSize){
		return studentCourseService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getbyid/{identity}")
	public StudentCourseResponse getById(@PathVariable Long identity) {
		return studentCourseService.getById(identity);
	}
	
	@PostMapping("/add")
	public StudentCourseResponse addStudent(@RequestBody @Validated StudentCourseRequest request) {
		return studentCourseService.add(request);
	}
	@PutMapping("{identity}")
	public StudentCourseResponse updateStudent(
			@PathVariable Long identity,
			@RequestBody @Validated StudentCourseRequest request) {
		return studentCourseService.update(identity, request);
	}
	@DeleteMapping("/{identity}")
	public StudentCourseResponse deleteStudent(@PathVariable Long identity) {
		return studentCourseService.delete(identity);
	}
	@PostMapping("/getGradesOfStudent")
	public StudentGradesResponse getGradesOfStudent(@RequestBody StudentGradesRequest request) {
		return studentCourseService.getGradesOfStudent(request);
		
	}
	@PostMapping("/getGradesOfAllStudents")
	public List<StudentGradesResponse> getGradesOfAllStudent(@RequestBody AllStudentsGradesRequest request) {
		return studentCourseService.getAllGradesofAllStudent(request);
		
	}
}
