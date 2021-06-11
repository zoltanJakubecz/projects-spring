package com.jakuza.projects.repository;

import com.jakuza.projects.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* ProjectRepository
*/
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
}
