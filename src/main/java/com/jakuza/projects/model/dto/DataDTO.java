package com.jakuza.projects.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* DataDTO
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DataDTO {
	
	@Builder.Default
	private List<ProjectDTO> projects = new ArrayList<>();


	public void addToList(ProjectDTO project){
		projects.add(project);
	}


}
