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

import com.example.school.dto.request.CourseRequest;
import com.example.school.dto.response.CourseResponse;
import com.example.school.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin
@RequestScope
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	@GetMapping("/getall")
	public List<CourseResponse> getAllByPage(
			@RequestParam(required = false, defaultValue = "0") 
			@Min(0) 
			int pageNo,
			@RequestParam(required = false, defaultValue = "20") 
			@Max(50) 
			int pageSize) {
		return courseService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getbyid/{code}")
	public CourseResponse getByCode(@PathVariable String code) {
		return courseService.getByCode(code);
	}
	@PostMapping("addcourse")
	public CourseResponse addCourse(@RequestBody @Validated CourseRequest request) {
		return courseService.addStudent(request);
	}
	@PutMapping("/{code}")
	public CourseResponse updateCourse(
			@PathVariable String code,
			@RequestBody @Validated CourseRequest request) {
		return courseService.updateStudent(code, request);
	}
	@DeleteMapping("/{code}")
	public CourseResponse deleteCourse(String code) {
		return courseService.deleteStudent(code);
	}
}


















