package com.jakuza.projects.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jakuza.projects.model.Project;
import com.jakuza.projects.model.dto.DataDTO;
import com.jakuza.projects.model.dto.ProjectDTO;

import org.springframework.stereotype.Service;

/**
* DataService
*/
@Service
public class DataService {

	private final ProjectService projectService;

	public DataService(ProjectService projectService){
		this.projectService = projectService;
	}

	public DataDTO getData(){

		List<Project> projects = projectService.getAll();
		List<ProjectDTO> projectDTOs = new ArrayList<>();

		projects.forEach(project -> projectDTOs.add(
					ProjectDTO.builder()
					.title(project.getTitle())
					.url(project.getUrl())
					.created(project.getCreated().toString().split("T")[0])
					.teamAvatarUrls(project
								.getTeams()
								.stream()
								.map(item -> item.getTeamAvatarUrl())
								.collect(Collectors.toList()))
					.build()
					));

		return DataDTO.builder().projects(projectDTOs).build();
	}
	
}
