package com.jakuza.projects.service;

import java.util.List;

import com.jakuza.projects.model.Team;
import com.jakuza.projects.repository.TeamRepository;

import org.springframework.stereotype.Service;

/**
* TeamService
*/
@Service
public class TeamService {
		
	private final TeamRepository repository;

	public TeamService(TeamRepository repository){
		this.repository = repository;
	}

	public List<Team> getAll(){
		return repository.findAll();
	}

	public Team addTeam(Team team){
		return repository.save(team);
	}
	
}
