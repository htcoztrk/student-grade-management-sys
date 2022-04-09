package com.example.school.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.school.SchoolApplication;
import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;
import com.example.school.entity.Student;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentService;
import com.example.school.service.business.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
@SpringBootTest(
		classes = SchoolApplication.class,
		webEnvironment = WebEnvironment.MOCK
	)
	@AutoConfigureMockMvc
public class StudentControllerTest {
	@Autowired
	MockMvc mockMvc;
	//@Autowired
	ModelMapper modelMapper;
	//@Autowired
	ObjectMapper objectMapper;
	//@Autowired
	StudentRepository studentRepository;
	//@MockBean
	//@Autowired
	StudentServiceImpl studentService;
	
	@BeforeEach
	public void setUp() throws Exception {
		studentRepository = Mockito.mock(StudentRepository.class);

		modelMapper = Mockito.mock(ModelMapper.class);
		objectMapper=Mockito.mock(ObjectMapper.class);
		studentService = new StudentServiceImpl(modelMapper, studentRepository);
	}

	@Test
	void getStudentByIdentityShouldreturnOk() throws Exception{
	/*	var student = new Student();
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
		Mockito.when(modelMapper.map(student, StudentResponse.class)).thenReturn(studentResponse);
		
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Mockito.when(studentService.getById(student.getIdentity())).thenReturn(studentResponse);
		
		//StudentResponse response = studentService.getById(1L);
		// 2. Call exercise method
		   mockMvc.perform(
		        	get("/customers/"+studentResponse.getIdentity())
		            .accept(MediaType.APPLICATION_JSON)
		        )
				// 3. Verification
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$.email",is(studentResponse.getEmail())))
		        .andExpect(jsonPath("$.name",is("hatice")))
		        .andExpect(jsonPath("$.surname",is("ozturk")))
		        .andExpect(jsonPath("$.phone",is("12345678909")));
		
		
		*/
	}
}
