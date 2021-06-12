package com.jakuza.projects.controller;

import java.util.List;

import com.jakuza.projects.model.Student;
import com.jakuza.projects.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* StudentController
*/
@RestController
@RequestMapping("/students") 
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService){
			this.studentService = studentService;
	}
	

	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		return ResponseEntity.ok().body(studentService.getAll());
	}


	@PostMapping
	public ResponseEntity<Student> addTeam(@RequestBody Student student){
		return ResponseEntity.ok().body(studentService.add(student));
	}


	@PutMapping("{studentId}/location/{locationId}")
	public ResponseEntity<Student> assignLocationToStuden(
				@PathVariable Long studentId,
				@PathVariable Long locationId){
			return ResponseEntity.ok().body(studentService.assignLocationToStudent(studentId, locationId));

	}
	
}
