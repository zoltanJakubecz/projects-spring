package com.jakuza.projects.service;

import java.util.List;

import com.jakuza.projects.model.Student;
import com.jakuza.projects.model.Team;
import com.jakuza.projects.repository.StudentRepository;
import com.jakuza.projects.repository.TeamRepository;

import org.springframework.stereotype.Service;

/**
* TeamService
*/
@Service
public class TeamService {
		
	private final TeamRepository repository;
	private final StudentRepository studentRepository;

	public TeamService(TeamRepository repository, StudentRepository studentRepository){
		this.repository = repository;
		this.studentRepository = studentRepository;
	}

	public List<Team> getAll(){
		return repository.findAll();
	}

	public Team add(Team team){
		return repository.save(team);
	}

	public Team addStudentToTeam(Long teamId, Long studentId){
		Team team = repository.findById(teamId).get();
		Student student = studentRepository.findById(studentId).get();

		team.addStudent(student);
		return repository.save(team);
	}
	
}
