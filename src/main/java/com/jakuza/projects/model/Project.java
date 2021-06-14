 package com.jakuza.projects.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Project
 */
 @Entity
 @Getter
 @Setter
 public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String url;

	private LocalDateTime created;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "team_project",
		joinColumns = @JoinColumn(name = "projects_id"),
		inverseJoinColumns = @JoinColumn(name = "team_id")
	)
	private Set<Team> teams = new HashSet<>();
 
	
	public void addTeam(Team team){
		teams.add(team);
	}


	
	public void validateName(){

		if(this.title == null || this.title.isBlank())
			throw new RuntimeException("Project title cannot be null or empty");

	}
}
