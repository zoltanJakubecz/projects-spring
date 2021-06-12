package com.jakuza.projects.controller;

import java.util.List;

import com.jakuza.projects.model.Project;
import com.jakuza.projects.service.ProjectService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* ProjectController
*/
@RestController
@RequestMapping("/projects")
public class ProjectController {

	private final ProjectService projectService;

	public ProjectController(ProjectService projectService){
		this.projectService = projectService;
	}


	@GetMapping
	public ResponseEntity<List<Project>> getTeams(){
		return ResponseEntity.ok().body(projectService.getAll());
	}


	@PostMapping
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		return ResponseEntity.ok().body(projectService.add(project));
	}


	@GetMapping("/{id}")
	public ResponseEntity<Project> getOne(@PathVariable Long id){
		return ResponseEntity.ok().body(projectService.getOne(id));
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project){
		return ResponseEntity.ok().body(projectService.update(id, project));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return ResponseEntity.ok().body(projectService.remove(id));
	}


	@PutMapping("/{projectId}/team/{teamId}")
	public ResponseEntity<Project> addTeamToProject(
				@PathVariable Long projectId,
				@PathVariable Long teamId
				){
					return ResponseEntity.ok().body(projectService.addTeamToProject(projectId, teamId));					
				}


}
