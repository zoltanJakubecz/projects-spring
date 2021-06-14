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


	public Team getOne(Long id){
		return repository
									.findById(id)
									.orElse(null);
	}


	public Team update(Long id, Team team){
		return repository.findById(id)
			.map((tm) -> {
				tm.setName(team.getName());
				tm.setTeamAvatarUrl(team.getTeamAvatarUrl());
				return repository.save(tm);
			})
		.orElse(null);
	}


	public boolean remove(Long id){

		if(!repository.existsById(id)) {
			throw new RuntimeException(
					"Team with id " + id + " does not exists");
		}
		repository.deleteById(id);
		return true;
	}


	public Team addStudentToTeam(Long teamId, Long studentId){
		Team team = repository.findById(teamId).get();
		Student student = studentRepository.findById(studentId).get();

		team.addStudent(student);
		student.addTeam(team);
		return repository.save(team);
	}
	
}
