package com.jakuza.projects.service;

import java.util.List;
import java.util.Optional;

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

	public Location getOne(Long id){
		Location location = locationRepository
														.findById(id)
														.orElse(null);
		return location;
	}

	public Location update(Long id, Location location){
		return locationRepository.findById(id)
			.map((loc) -> {
				loc.setName(location.getName());
				loc.setAddress(location.getAddress());
				return locationRepository.save(loc);
			})
		.orElse(null);
	}


	public boolean remove(Long id){

		Optional<Location> location = locationRepository.findById(id);
														
		if(location.isPresent()){
			locationRepository.delete(location.get());
			return true;
		}
		return false;
	}

}
