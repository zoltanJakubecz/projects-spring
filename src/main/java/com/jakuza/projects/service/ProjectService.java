package com.jakuza.projects.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
		project.setCreated(LocalDateTime.now());
		return projectRepository.save(project);
	}

	
	public Project getOne(Long id){
		Project location = projectRepository
														.findById(id)
														.orElse(null);
		return location;
	}

	
	public Project update(Long id, Project project){
		return projectRepository.findById(id)
			.map((proj) -> {
				proj.setTitle(project.getTitle());
				proj.setUrl(project.getUrl());
				proj.setCreated(project.getCreated());
				return projectRepository.save(proj);
			})
		.orElse(null);
	}


	public boolean remove(Long id){

		Optional<Project> project = projectRepository.findById(id);
														
		if(project.isPresent()){
			projectRepository.delete(project.get());
			return true;
		}
		return false;
	}


	public Project addTeamToProject(Long projectId, Long teamId){
		Project project = projectRepository.findById(projectId).get();
		Team team = teamRepository.findById(teamId).get();
	
		project.addTeam(team);
		team.addProject(project);

		return projectRepository.save(project);
		 

	}

	
}
