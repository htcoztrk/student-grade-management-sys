package com.example.school.service.business;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.school.dto.request.StudentRequest;
import com.example.school.dto.response.StudentResponse;
import com.example.school.entity.Student;
import com.example.school.exception.RestExceptionBase;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private final ModelMapper modelMapper;
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(ModelMapper modelMapper, StudentRepository studentRepository) {
		this.modelMapper = modelMapper;
		this.studentRepository = studentRepository;
	}

	@Override
	@Transactional
	public StudentResponse addStudent(StudentRequest request) {
		var student=modelMapper.map(request, Student.class);
		return modelMapper.map(studentRepository.save(student),StudentResponse.class );
	}

	@Override
	@Transactional
	public StudentResponse updateStudent(Long identity,StudentRequest request) {
		var student=studentRepository.findById(identity)
				.orElseThrow(()->new RestExceptionBase("Can not find the Student!", "unknown.student","1"));
		modelMapper.map(request,student);	
		return modelMapper.map(studentRepository.save(student), StudentResponse.class);
	}
	@Override
	@Transactional
	public StudentResponse deleteStudent(Long identity) {
		var student=studentRepository.findById(identity).orElseThrow(()-> new RestExceptionBase("Can not find the Student!", "unknown.student","2"));
		studentRepository.deleteById(student.getIdentity());
		return modelMapper.map(student, StudentResponse.class);	
		
	}

	@Override
	public StudentResponse getById(Long id) {
		var student=studentRepository.findById(id).orElseThrow(()->new RestExceptionBase("Can not find the Student!", "unknown.student","3"));
		return modelMapper.map(student,StudentResponse.class );
	}

	@Override
	public List<StudentResponse> getAllByPage(int pageNo,int pageSize) {
		return studentRepository.findAll(PageRequest.of(pageNo, pageSize))
				.stream()
				.map(student->modelMapper.map(student, StudentResponse.class))
				.sorted(Comparator.comparing(StudentResponse::getName))
				.toList();
	}

	@Override
	public List<StudentResponse> getByName(String name) {
		return studentRepository.findByName(name)
				.stream()
				.map(student->modelMapper.map(student, StudentResponse.class))
				.toList();
				
	}

	@Transactional
	public StudentResponse patchStudent(Long identity, Map<String, Object> request) {
		var student=studentRepository.findById(identity).orElseThrow(()->new EntityNotFoundException());
		request.forEach((property,value)->{
			Field declaredField;
			try {
				declaredField=Student.class.getDeclaredField(property);
				if(property.equals("phone")) {
					declaredField.setAccessible(true);
					declaredField.set(student, value.toString());
					declaredField.setAccessible(false);
				}
			} catch (Exception e) {
				
			}
		});
		return modelMapper.map(
				studentRepository.save(student), 
				StudentResponse.class);
	}

	@Override
	public List<StudentResponse> getAll() {
		return studentRepository.findAll()
				.stream()
				.map(student->modelMapper.map(student, StudentResponse.class))
				.sorted(Comparator.comparing(StudentResponse::getName))
				.toList();
	}

}
