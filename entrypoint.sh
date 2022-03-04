#!/bin/bash
java -Dspring.profiles.active=${PROFILE_ENV} -XX:+UseG1GC -Djava.security.egd=file:/dev/./urandom -Dloader.main=com.springboot.tutorial.MainApplication.java -jar app.jar
