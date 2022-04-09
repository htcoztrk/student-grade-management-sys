package com.example.school.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.school.dto.response.StudentGradesResponse;
import com.example.school.entity.StudentCourse;


@Configuration
public class ModelMapperConfig {

	private static final Converter<StudentCourse,StudentGradesResponse>
	CONVERT_STUDENT_COURSE_TO_STUDENT_GRADES_RESPONSE=(context)->{
		var source=context.getSource();
		var response=new StudentGradesResponse();
		response.setStudentId(source.getStudent().getIdentity());
		response.setExam1(source.getExam1());
		response.setExam2(source.getExam2());
		response.setAverageGrade(source.getAverage());
		return response;
	};
	
	@Bean
	public ModelMapper mapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(CONVERT_STUDENT_COURSE_TO_STUDENT_GRADES_RESPONSE,StudentCourse.class,StudentGradesResponse.class);
		return mapper;
	}
}
