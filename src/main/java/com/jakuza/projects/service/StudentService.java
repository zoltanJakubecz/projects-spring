package com.jakuza.projects.service;

import java.util.List;

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
		return studentRepository.save(student);
	}
	
	public Student assignLocationToStudent(Long studentId, Long locationId){
		Location location = locationRepository.findById(locationId).get();
		Student student = studentRepository.findById(studentId).get();
		
		student.assignLocation(location);
		location.addStudent(student);
		return studentRepository.save(student);
	}

}
