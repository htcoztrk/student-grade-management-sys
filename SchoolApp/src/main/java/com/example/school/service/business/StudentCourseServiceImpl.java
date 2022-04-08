package com.example.school.service.business;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.school.dto.request.GradesRequest;
import com.example.school.dto.request.StudentCourseRequest;
import com.example.school.dto.request.StudentGradesRequest;
import com.example.school.dto.response.StudentCourseResponse;
import com.example.school.dto.response.StudentGradesResponse;
import com.example.school.entity.StudentCourse;
import com.example.school.exception.RestExceptionBase;
import com.example.school.repository.StudentCourseRepository;
import com.example.school.service.StudentCourseService;
import java.util.function.Predicate;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	private final ModelMapper modelMapper;
	private final StudentCourseRepository studentCourseRepository;

	public StudentCourseServiceImpl(ModelMapper modelMapper, StudentCourseRepository studentCourseRepository) {
		this.modelMapper = modelMapper;
		this.studentCourseRepository = studentCourseRepository;
	}

	@Override
	@Transactional
	public StudentCourseResponse add(StudentCourseRequest request) {
		var studentCourse = modelMapper.map(request, StudentCourse.class);
		var addedStudentCourse = studentCourseRepository.save(studentCourse);
		return modelMapper.map(addedStudentCourse, StudentCourseResponse.class);
	}

	@Override
	@Transactional
	public StudentCourseResponse update(Long identity, StudentCourseRequest request) {
		var studentCourse = studentCourseRepository.findById(identity)
				.orElseThrow(() -> new RestExceptionBase("There is no such id", "unknown.studentcourse", "1"));
		modelMapper.map(request, studentCourse);
		return modelMapper.map(studentCourseRepository.saveAndFlush(studentCourse), StudentCourseResponse.class);

	}

	@Override
	public StudentCourseResponse delete(Long identity) {
		var studentCourse = studentCourseRepository.findById(identity)
				.orElseThrow(() -> new RestExceptionBase("There is no such id", "unknown.studentcourse", "2"));
		studentCourseRepository.deleteById(identity);
		return modelMapper.map(studentCourse, StudentCourseResponse.class);
	}

	@Override
	public StudentCourseResponse getById(Long identity) {
		var studentCourse = studentCourseRepository.findById(identity)
				.orElseThrow(() -> new RestExceptionBase("There is no such id", "unknown.studentcourse", "3"));
		return modelMapper.map(studentCourse, StudentCourseResponse.class);
	}

	@Override
	public List<StudentCourseResponse> getAll(int pageNo, int pageSize) {
		return studentCourseRepository.findAll(PageRequest.of(pageNo, pageSize)).stream()
				.map(studentCourse -> modelMapper.map(studentCourse, StudentCourseResponse.class)).toList();
	}

	@Override
	public StudentGradesResponse getGradesOfStudent(StudentGradesRequest request) {
		Predicate<StudentCourse> isStudentPredicate = i -> i.getStudent().getIdentity().equals(request.getStudentId());
		Predicate<StudentCourse> isCoursePredicate = i -> i.getCourse().getCode().equals(request.getCourseCode());
		Predicate<StudentCourse> isYearPredicate = i -> i.getCourseYear().equals(request.getCourseYear());
		var result = studentCourseRepository.findAll()
				.stream()
				.filter(isStudentPredicate.and(isCoursePredicate).and(isYearPredicate))
				.map(studentCourse -> modelMapper.map(studentCourse, StudentGradesResponse.class))
				.findAny();
        result.get().setAverageGrade((result.get().getExam1()+result.get().getExam2())/2);
		return result.get();
	}

	@Override
	public List<StudentGradesResponse> getAllGradesofAllStudent(GradesRequest request) {
		Predicate<StudentCourse> isCoursePredicate = i -> i.getCourse().getCode().equals(request.getCourseCode());
		Predicate<StudentCourse> isYearPredicate = i -> i.getCourseYear().equals(request.getCourseYear());
		var result=studentCourseRepository.findAll()
				.stream()
				.filter(isYearPredicate.and(isCoursePredicate))
				.map(studentCourse->modelMapper.map(studentCourse, StudentGradesResponse.class))
				.toList();
		
		result.forEach(s->s.setAverageGrade((s.getExam1()+s.getExam2())/2));
		return result;
	}

}
