package com.jakuza.projects.service;

import java.util.List;
import java.util.Optional;

import com.jakuza.projects.model.Location;
import com.jakuza.projects.model.Student;
import com.jakuza.projects.repository.LocationRepository;
import com.jakuza.projects.repository.StudentRepository;

import org.springframework.stereotype.Service;

/**
* StudentService
*/
@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	private final LocationRepository locationRepository;

	
	public StudentService(StudentRepository studentRepository, LocationRepository locationRepository){
		this.studentRepository = studentRepository;
		this.locationRepository = locationRepository;
	}

	
	public List<Student> getAll(){
		return studentRepository.findAll();
	}


	public Student add(Student student){
		Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
		if(existsEmail){
			throw new RuntimeException("Email " + student.getEmail() + " taken");
		}
		student.validate();
		return studentRepository.save(student);
	}
	

	public Student getOne(Long id){
		return studentRepository
									.findById(id)
									.orElse(null);
	}


	public Student update(Long id, Student student){
		return studentRepository.findById(id)
			.map((stu) -> {
				stu.setName(student.getName());
				stu.setEmail(student.getEmail());
				return studentRepository.save(stu);
			})
		.orElse(null);
	}


	public boolean remove(Long id){

		if(!studentRepository.existsById(id)) {
			throw new RuntimeException(
					"Student with id " + id + " does not exists");
		}
		studentRepository.deleteById(id);
		return true;
	}


	public Student assignLocationToStudent(Long studentId, Long locationId){
		Location location = locationRepository.findById(locationId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		
		if(location == null || student == null ) throw new RuntimeException("Wrong id given");
		student.assignLocation(location);
		location.addStudent(student);
		return studentRepository.save(student);
	}

}
