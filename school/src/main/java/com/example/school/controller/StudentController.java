package com.example.school.controller;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;
import com.example.school.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
@RequestScope
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/getallByPage")
	public List<StudentResponse> getAllByPage(
			@RequestParam(required = false, defaultValue = "0") 
			@Min(0) 
			int pageNo,
			@RequestParam(required = false, defaultValue = "20") 
			@Max(50) 
			int pageSize) {
		return studentService.getAllByPage(pageNo, pageSize);
	}
	@GetMapping("/getbyid/{identity}")
	public StudentResponse getById(@PathVariable Long identity) {
		return studentService.getById(identity);
	}
	@PostMapping("/add")
	public StudentResponse addStudent(@RequestBody @Validated StudentRequest request) {
		return studentService.addStudent(request);
	}
	@PutMapping("{identity}")
	public StudentResponse updateStudent(
			@PathVariable Long identity,
			@RequestBody @Validated StudentRequest request) {
		return studentService.updateStudent(identity, request);
	}
	@PatchMapping("{identity}")
	public StudentResponse patchStudent(
			@PathVariable Long identity,
			@RequestBody Map<String,Object> request) {
		return studentService.patchStudent(identity,request);
	}
	@DeleteMapping("/{identity}")
	public StudentResponse deleteStudent(@PathVariable Long identity) {
		return studentService.deleteStudent(identity);
	}
	@GetMapping("/getall")
	public List<StudentResponse> getAll(
			) {
		return studentService.getAll();
	}
}




