package com.example.school.service;

import java.util.List;

import com.example.school.dto.request.CourseRequest;
import com.example.school.dto.response.CourseResponse;

public interface CourseService {

	CourseResponse addStudent(CourseRequest request);
	CourseResponse updateStudent(String code,CourseRequest request);
	CourseResponse deleteStudent(String code);
	CourseResponse getByCode(String code);
	List<CourseResponse> getAll(int pageNo,int pageSize);
}
