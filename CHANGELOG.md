# Changelog
All notable changes to this project will be documented in this file.<br>
The format is based on [Keep a Changelog](http://keepachangelog.com/) and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]
### Added
- Will add an UI for adding courses and students.
- Will add JUnit test cases for all the classes.
- Will create a docker-compose file for mysql DB.
- Will integrate with Flyway.

## [2.0.0] - 2022-03-02
### Added
- Added JUnit tests for all the classes.
- Added docker-compose file for mysql DB.
- Integration with flyway.

### Changed
- Updated the Dtos to remove the manual getter and setter and use lombok annotations.
- Updated the @GeneratedValue annotation to use the DB sequences.

### Removed
- Removed older APIs to add students.

## [1.0.0] - 2022-02-11
### Added
- Added Student, Course, Schedule, Location Entity
- Added Registration Entity to add student to a course
- Added TimeTable Entity to add course timetable with location and schedule 
- Added repository pattern
- Added AWS configuration for AWS RDS

[2.0.0]: https://jira.mypaytm.com/browse/AT-1770