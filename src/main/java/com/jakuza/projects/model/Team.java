package com.jakuza.projects.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Team
*/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String teamAvatarUrl;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "student_team",
		joinColumns = @JoinColumn(name = "team_id"),
		inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	private Set<Student> students = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "teams", fetch = FetchType.EAGER)
	private Set<Project> projects = new HashSet<>();


	public void addStudent(Student student){
		students.add(student);
	}

	
	public void addProject(Project project){
		projects.add(project);
	}
	
}
