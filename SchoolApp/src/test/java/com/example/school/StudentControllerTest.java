package com.example.school;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;
import com.example.school.entity.Student;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentControllerTest {

	@MockBean
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@BeforeEach
	public void setUp() throws Exception{
		studentRepository=Mockito.mock(StudentRepository.class);
		studentService=Mockito.mock(StudentService.class);
		modelMapper=Mockito.mock(ModelMapper.class);
		mockMvc=Mockito.mock(MockMvc.class);
		objectMapper=Mockito.mock(ObjectMapper.class);
	}
	@Test
	void addStudentShouldReturnOk() throws JsonProcessingException, Exception {
		var request=new StudentRequest();
		request.setEmail("hatice@gmail.com");
		request.setName("hatice");
		request.setSurname("ozturk");
		request.setPhone("12345678909");
		
		var student=modelMapper.map(request, Student.class);
		var response=modelMapper.map(student,StudentResponse.class);
		Mockito.when(studentService.addStudent(request))
		.thenReturn(response);
		
		// 2. Call exercise method
				mockMvc.perform(
						post("/student")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request))
				)
				// 3. Verification
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$.email",is("hatice@gmail.com")))
		        .andExpect(jsonPath("$.name",is("hatice")))
		        .andExpect(jsonPath("$.surname",is("ozturk")))
		        .andExpect(jsonPath("$.phone",is("12345678909")));
		
	}
	
	
}
