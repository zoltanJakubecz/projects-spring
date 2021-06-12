package com.jakuza.projects.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* ProjectDTO
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectDTO {

	private String title;
	private String url;
	@Builder.Default
	private List<String> teamAvatarUrls = new ArrayList<>();
	private String created;

}
