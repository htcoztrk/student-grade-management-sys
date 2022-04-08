package com.example.school.service;

import java.util.List;

import com.example.school.dto.request.GradesRequest;
import com.example.school.dto.request.StudentCourseRequest;
import com.example.school.dto.request.StudentGradesRequest;
import com.example.school.dto.response.StudentCourseResponse;
import com.example.school.dto.response.StudentGradesResponse;

public interface StudentCourseService {

	StudentCourseResponse add(StudentCourseRequest request);
	StudentCourseResponse update(Long identity,StudentCourseRequest request);
	StudentCourseResponse delete(Long identity);
	StudentCourseResponse getById(Long identity);
	List<StudentCourseResponse> getAll(int pageNo,int pageSize);
	StudentGradesResponse getGradesOfStudent(StudentGradesRequest request);
	List<StudentGradesResponse> getAllGradesofAllStudent(GradesRequest request);
}
