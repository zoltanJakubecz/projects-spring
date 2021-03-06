package com.jakuza.projects.controller;

import java.util.List;

import com.jakuza.projects.model.Team;
import com.jakuza.projects.service.TeamService;

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
* TeamController
*/
@RestController
@RequestMapping("/teams")
public class TeamController {

	private final TeamService teamService;

	
	public TeamController(TeamService teamService){
		this.teamService = teamService;
	}

	
	@GetMapping
	public ResponseEntity<List<Team>> getTeams(){
		return ResponseEntity.ok().body(teamService.getAll());
	}

	
	@PostMapping
	public ResponseEntity<Team> addTeam(@RequestBody Team team){
		return ResponseEntity.ok().body(teamService.add(team));
	}


	@GetMapping("/{id}")
	public ResponseEntity<Team> getOne(@PathVariable Long id){
		return ResponseEntity.ok().body(teamService.getOne(id));
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Team> update(@PathVariable Long id, @RequestBody Team team){
		return ResponseEntity.ok().body(teamService.update(id, team));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return ResponseEntity.ok().body(teamService.remove(id));
	}
	

	@PutMapping("/{teamId}/student/{studentId}")
	public ResponseEntity<Team> addStudentToTeam(
			@PathVariable Long teamId,
			@PathVariable Long studentId
			){

		return ResponseEntity.ok().body(teamService.addStudentToTeam(teamId, studentId)) ;

	}


}
