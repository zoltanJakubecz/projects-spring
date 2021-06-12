package com.jakuza.projects.controller;

import java.util.List;

import com.jakuza.projects.model.Location;
import com.jakuza.projects.service.LocationService;

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
* LocationController
*/
@RestController
@RequestMapping("/locations")
public class LocationController {

	private final LocationService locationService;

	public LocationController(LocationService locationService){
		this.locationService = locationService;
	}


	@GetMapping
	public ResponseEntity<List<Location>> getAll(){
		return ResponseEntity.ok().body(locationService.getAll());
	}

	
	@PostMapping
	public ResponseEntity<Location> add(@RequestBody Location location){
		return ResponseEntity.ok().body(locationService.add(location));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Location> getOne(@PathVariable Long id){
		return ResponseEntity.ok().body(locationService.getOne(id));
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Location> update(@PathVariable Long id, @RequestBody Location location){
		return ResponseEntity.ok().body(locationService.update(id, location));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id){
		return ResponseEntity.ok().body(locationService.remove(id));
	}

}
