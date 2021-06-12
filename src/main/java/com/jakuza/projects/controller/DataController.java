package com.jakuza.projects.controller;

import com.jakuza.projects.model.dto.DataDTO;
import com.jakuza.projects.service.DataService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* DataController
*/
@RestController
@RequestMapping("/data")
public class DataController {

	private final DataService dataService;

	DataController(DataService dataService){
		this.dataService = dataService;
	}

	@GetMapping
	public ResponseEntity<DataDTO> getData(){
		return ResponseEntity.ok().body(dataService.getData());
	}
	
}
