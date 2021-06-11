package com.jakuza.projects.repository;

import com.jakuza.projects.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* TeamRepository
*/
public interface TeamRepository extends JpaRepository<Team, Long> {

}
