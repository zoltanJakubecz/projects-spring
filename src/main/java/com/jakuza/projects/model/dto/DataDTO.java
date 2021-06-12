package com.jakuza.projects.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DataDTO
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataDTO {

	private List<ProjectDTO> projects = new ArrayList<>();


	public void addToList(ProjectDTO project){
		projects.add(project);
	}


}
