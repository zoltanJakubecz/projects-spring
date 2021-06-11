package com.jakuza.projects.repository;

import com.jakuza.projects.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* StudentRepository
*/
public interface StudentRepository extends JpaRepository<Student, Long> {

	
}
