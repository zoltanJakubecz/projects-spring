package com.jakuza.projects.service;

import java.util.List;

import com.jakuza.projects.model.Student;
import com.jakuza.projects.repository.StudentRepository;

import org.springframework.stereotype.Service;

/**
* StudentService
*/
@Service
public class StudentService {
	
	private final StudentRepository repository;

	public StudentService(StudentRepository repository){
		this.repository = repository;
	}

	public List<Student> getAll(){
		return repository.findAll();
	}


	public Student add(Student student){
		return repository.save(student);
	}
	
}
