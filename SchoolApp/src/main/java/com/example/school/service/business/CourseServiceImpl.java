package com.example.school.service.business;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.school.dto.request.CourseRequest;
import com.example.school.dto.response.CourseResponse;
import com.example.school.entity.Course;
import com.example.school.exception.RestExceptionBase;
import com.example.school.repository.CourseRepository;
import com.example.school.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	private final CourseRepository courseRepository;
	private final ModelMapper modelMapper;
	
	public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
		this.courseRepository = courseRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public CourseResponse addStudent(CourseRequest request) {
		var course=modelMapper.map(request, Course.class);
		return modelMapper.map(courseRepository.save(course), CourseResponse.class);
	}

	@Override
	@Transactional
	public CourseResponse updateStudent(String code, CourseRequest request) {
		var course=courseRepository.findById(code)
				.orElseThrow(()->new RestExceptionBase("Can not find the course!", "unknown.course", "1"));
		modelMapper.map(request, course);
		return modelMapper.map(course, CourseResponse.class);
	}

	@Override
	public CourseResponse deleteStudent(String code) {
		var course=courseRepository.findById(code)
				.orElseThrow(()->new RestExceptionBase("Can not find the course","unknown.course", "2"));
		courseRepository.deleteById(code);
		return modelMapper.map(course, CourseResponse.class);
	}

	@Override
	public CourseResponse getByCode(String code) {
		var course=courseRepository.findById(code)
				.orElseThrow(()->new RestExceptionBase("Can not find the course!", "unknown.course", "3"));
		return modelMapper.map(course, CourseResponse.class);
	}


	@Override
	public List<CourseResponse> getAll(int pageNo, int pageSize) {
		return courseRepository.findAll(PageRequest.of(pageNo, pageSize))
				.stream()
				.map(course->modelMapper.map(course, CourseResponse.class))
				.toList();
	}

	

	
}
