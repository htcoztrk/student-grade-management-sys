package com.example.school;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;
import com.example.school.entity.Student;
import com.example.school.exception.RestExceptionBase;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentService;
import com.example.school.service.business.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentTest2 {
	//@MockBean
	//@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ObjectMapper objectMapper;
	@BeforeEach
	public void setUp() throws Exception{
		studentRepository=Mockito.mock(StudentRepository.class);
		
		modelMapper=Mockito.mock(ModelMapper.class);
		objectMapper=Mockito.mock(ObjectMapper.class);
		studentService=new StudentServiceImpl(modelMapper,studentRepository);
	}
	@Test
	void addStudentShouldReturnOk() throws JsonProcessingException, Exception {
		var request=new StudentRequest();
		request.setEmail("hatice@gmail.com");
		request.setName("hatice");
		request.setSurname("ozturk");
		request.setPhone("12345678909");
		request.setPassword("dcds");
		request.setUsername("fffvf");
		System.err.println(request);
		Student student=new Student();
		student.setIdentity(1L);
		student.setEmail("hatice@gmail.com");
		student.setName("hatice");
		student.setSurname("ozturk");
		student.setPhone("12345678909");
	
		StudentResponse response=new StudentResponse();
		response.setEmail("hatice@gmail.com");
		response.setName("hatice");
		response.setSurname("ozturk");
		response.setPhone("12345678909");
		response.setIdentity(1L);
		System.err.println(response);
		Mockito.when(modelMapper.map(request, Student.class)).thenReturn(student);
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(response);
		
		StudentResponse response2=studentService.addStudent(request);
		System.err.println(response2);
		assertEquals(response,response2);
	}
	
	@Test
	void getStudentByIdShouldReturnOk() {
		var student=new Student();
		student.setIdentity(1L);
		student.setEmail("someone@gmail.com");
		student.setName("someone");
		student.setPhone("12345678901");
		student.setSurname("surname");
		var studentResponse=new StudentResponse();
		studentResponse.setIdentity(1L);
		studentResponse.setEmail("someone@gmail.com");
		studentResponse.setName("someone");
		studentResponse.setPhone("12345678901");
		studentResponse.setSurname("surname");
		
		System.err.println(student);
		System.err.println(studentResponse);
		
		Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
		System.err.println(student.getIdentity());
		StudentResponse response=studentService.getById(1L);
		System.err.println(student.getIdentity());
		assertEquals(studentResponse, response);
	}
	@Test
	void getStudentByIdShouldReturnNotFound() {
		Mockito.when(studentRepository.findById(1L)).thenThrow(IllegalArgumentException.class);
		//var student=studentService.getById(1L);
		assertThrows(IllegalArgumentException.class, () -> studentService.getById(1L));
	}
}






