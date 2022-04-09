package com.example.school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;
import com.example.school.entity.Student;
import com.example.school.exception.RestExceptionBase;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentService;
import com.example.school.service.business.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class StudentServiceTest {

	private StudentService studentService;

	private StudentRepository studentRepository;

	private ModelMapper modelMapper;

	@BeforeEach
	public void setUp() throws Exception {
		studentRepository = Mockito.mock(StudentRepository.class);

		modelMapper = Mockito.mock(ModelMapper.class);

		studentService = new StudentServiceImpl(modelMapper, studentRepository);
	}

	@Test
	void addStudentShouldReturnOk() throws JsonProcessingException, Exception {
		var request = new StudentRequest();
		request.setEmail("hatice@gmail.com");
		request.setName("hatice");
		request.setSurname("ozturk");
		request.setPhone("12345678909");
		request.setPassword("dcds");
		request.setUsername("fffvf");
		
		Student student = new Student();
		student.setIdentity(1L);
		student.setEmail("hatice@gmail.com");
		student.setName("hatice");
		student.setSurname("ozturk");
		student.setPhone("12345678909");

		StudentResponse response = new StudentResponse();
		response.setEmail("hatice@gmail.com");
		response.setName("hatice");
		response.setSurname("ozturk");
		response.setPhone("12345678909");
		response.setIdentity(1L);
		
		Mockito.when(modelMapper.map(request, Student.class)).thenReturn(student);
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(response);

		StudentResponse response2 = studentService.addStudent(request);
		
		assertEquals(response, response2);
	}

	@Test
	void getStudentByIdShouldReturnOk() {
		var student = new Student();
		student.setIdentity(1L);
		student.setEmail("someone@gmail.com");
		student.setName("someone");
		student.setPhone("12345678901");
		student.setSurname("surname");
		var studentResponse = new StudentResponse();
		studentResponse.setIdentity(1L);
		studentResponse.setEmail("someone@gmail.com");
		studentResponse.setName("someone");
		studentResponse.setPhone("12345678901");
		studentResponse.setSurname("surname");

		Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
		
		StudentResponse response = studentService.getById(1L);
		
		assertEquals(studentResponse, response);
	}

	@Test
	void getStudentByIdShouldReturnNotFound() {
		Mockito.when(studentRepository.findById(1L)).thenThrow(RestExceptionBase.class);
		// var student=studentService.getById(1L);
		assertThrows(RestExceptionBase.class, () -> studentService.getById(1L));
	}

	@Test
	void getAllStudentsTest() {
		var student = new Student();
		StudentResponse studentResponse = new StudentResponse();
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
		Mockito.when(studentRepository.findAll()).thenReturn(List.of(student));

		List<StudentResponse> result = studentService.getAll();

		assertEquals(result, List.of(studentResponse));

	}

	@Test
	void getByStudentNameShouldReturnOk() {
		String name = "someone";
		var student = new Student();
		student.setName(name);
		StudentResponse studentResponse = new StudentResponse();
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
		Mockito.when(studentRepository.findByName(name)).thenReturn(List.of(student));
		List<StudentResponse> result = studentService.getByName(name);

		assertEquals(result, List.of(studentResponse));
	}

	@Test
	void removeStudentByExistIdShouldReturnOk() {
		var student = new Student();
		student.setIdentity(1L);

		Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

		//var result = studentService.deleteStudent(student.getIdentity());
		studentService.deleteStudent(student.getIdentity());
		// studentRepository.deleteById(1L);
		//System.out.println(result);
		verify(studentRepository, times(1)).deleteById(student.getIdentity());
		// assertEquals(student, result);
	}
	@Test
	void removeStudentByNotExistIdShouldReturnNotFound() {
		
		Mockito.when(studentRepository.findById(1L)).thenThrow(RestExceptionBase.class);
		assertThrows(RestExceptionBase.class, () -> studentService.deleteStudent(1L));
	}
}
