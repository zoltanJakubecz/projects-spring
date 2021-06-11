package com.jakuza.projects.service;

import java.util.List;

import com.jakuza.projects.model.Project;
import com.jakuza.projects.model.Team;
import com.jakuza.projects.repository.ProjectRepository;
import com.jakuza.projects.repository.TeamRepository;

import org.springframework.stereotype.Service;

/**
* ProjectService
*/
@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	private final TeamRepository teamRepository;

	public ProjectService(ProjectRepository projectRepository, TeamRepository teamRepository){
		this.projectRepository = projectRepository;
		this.teamRepository = teamRepository;
	}


	public List<Project> getAll(){
		return projectRepository.findAll();
	}

	public Project add(Project project){
		return projectRepository.save(project);
	}

	public Project addTeamToProject(Long projectId, Long teamId){
		Project project = projectRepository.findById(projectId).get();
		Team team = teamRepository.findById(teamId).get();
	
		project.addTeam(team);
		team.addProject(project);

		return projectRepository.save(project);
		 

	}

	
}
