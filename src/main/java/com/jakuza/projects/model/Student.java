package com.jakuza.projects.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Student
*/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private HashMap<String, Integer> experiencePoints = new HashMap<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location location;

	@JsonIgnore
	@ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
	private Set<Team> teams = new HashSet<>();
		
	
	public void addTeam(Team team){
		teams.add(team);
	}

	public void assignLocation(Location location){
		this.location = location;
	}

}
