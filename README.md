# Project Manager Application Backend

## Task description

This application manages users and teams who work on projects. A user can be a member of more than one
teams, and a team can work on more than one projects at the same time. Every user has a location which they work from and every user has experience points (between 1 and 100) in several technologies.

###Used technologies

* Java 8
* Maven
* Spring Boot
* JPA
* Hibernate
* PostgreSQL
* H2 in-memory database for testing


## Classes

###Student


* name - Not null or empty string
* email - Not null or empty string
* teams - List of teams wher the student member of
* location - Location where the strudent works from
* experiencePoints - HashMap, String Integer pairs storeing experience points


###Team


* name - Not null or empty string
* teamAvatarUrl - String
* students - List of students in the team
* projects - list of projects the team is working on


###Project

* title - Not null or empty string
* url - remote store address of the project
* created - timestamp when the project created
* teams - list of teams work on the project


###Location

* name - Not null or empty string
* address - Not null or empty string
* students - List of students work from this location


##Data transfer objects (DTO)

###ProjectDTO

* title - string
* url - string
* teamAvatars - List of string
* created - Timestamp

###DataDTO

* projects - List of ProhectDTO


##Relations between classes

* team - student -> Many to many relation
* team - project -> Many to many relation
* student - location -> One to many relation

##API endpoints
###Student
/students

* get - List all of stored student
* post - Add new student

/student/{id}

* get - Get one student
* put - Update a student
* delete - Delete a student

/student/{id}/location/{locationId}

* put - assign a location to a student

###Team
/teams

* get - List of teams
* post - Add new team

/teams/{id}

* get - Get one team
* put - Update a team
* delete - Delete a team

/teams/{id}/student/{id}

* put - Add studet to team

###Project

/projects

* get - List of projects
* post - Add new project

/projects/{id}

* get - Get one project
* put - Update a project
* delete - Delete a project

/projects/{id}/team/{teamId}

* put - Assign a team to a project

###Location

/location

* get - List of locations
* post - Add new location

/location/{id}

* get - Get one location
* put - Update a location
* delete - Delete a location


###Data

/data

* get - response with the data given in Task Description

