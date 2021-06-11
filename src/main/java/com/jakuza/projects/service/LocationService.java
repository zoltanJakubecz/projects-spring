package com.jakuza.projects.service;

import java.util.List;

import com.jakuza.projects.model.Location;
import com.jakuza.projects.repository.LocationRepository;

import org.springframework.stereotype.Service;

/**
* LocationService
*/
@Service
public class LocationService {

	private final LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository){
		this.locationRepository = locationRepository;
	}


	public List<Location> getAll(){
		return locationRepository.findAll();
	}


	public Location add(Location location){
		return locationRepository.save(location);
	}

	
}
