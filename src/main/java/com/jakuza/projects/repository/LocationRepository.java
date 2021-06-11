package com.jakuza.projects.repository;

import com.jakuza.projects.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* LocationRepository
*/
public interface LocationRepository extends JpaRepository<Location, Long> {

	
}
