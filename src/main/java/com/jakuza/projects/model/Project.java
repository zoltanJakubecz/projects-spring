 package com.jakuza.projects.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Project
 */
 @Entity
 @Getter
 @Setter
 public class Project {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String title;

	 private String url;

	 private String[] teamAvatarUrls;

	 private LocalDateTime created;
 	
 }
