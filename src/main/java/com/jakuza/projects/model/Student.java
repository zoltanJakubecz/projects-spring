package com.jakuza.projects.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


	public void validate(){
		validateName();
		validateEmail();
		validateExperience();
	}


	public void validateName(){

		if(this.name == null || this.name.isBlank())
			throw new RuntimeException("Name cannot be null or empty");

	}


	public void validateEmail(){

		if(this.email == null || this.email.isBlank()){
			throw new RuntimeException("Name cannot be null or empty");
		}
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    		    Pattern pattern =Pattern.compile(regex);
        		Matcher matcher = pattern.matcher(this.email);
						if(!matcher.matches()){
							throw new RuntimeException("Wrong email");
						}

	}


	public void validateExperience(){

		for(Map.Entry<String, Integer> entry: this.experiencePoints.entrySet()){
			if(entry.getKey() == null || entry.getKey().isBlank())
				throw new RuntimeException("Experience cannot be null or empty");
			if(!(entry.getValue() >= 1 && entry.getValue()<=100))
				throw new RuntimeException("Experience points must be between 1 and 100");
		}

	}

}
