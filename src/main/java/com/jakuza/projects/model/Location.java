package com.jakuza.projects.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Location
*/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<>();

	public void addStudent(Student student){
		students.add(student);
	}


	public void validateName(){

		if(this.name == null || this.name.isBlank())
			throw new RuntimeException("Name cannot be null or empty");

	}
}
