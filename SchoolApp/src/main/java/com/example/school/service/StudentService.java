package com.example.school.service;

import java.util.List;
import java.util.Map;

import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;

public interface StudentService {

	StudentResponse addStudent(StudentRequest request);
	StudentResponse updateStudent(Long identity,StudentRequest request);
	StudentResponse deleteStudent(Long identity);
	StudentResponse getById(Long id);
	List<StudentResponse> getAllByPage(int pageNo,int pageSize);
	List<StudentResponse> getAll();
	List<StudentResponse> getByName(String name);
	StudentResponse patchStudent(Long id,Map<String, Object> request);
}
