#!/bin/bash
java -XX:+UseG1GC -Djava.security.egd=file:/dev/./urandom -Dloader.main=com.springboot.tutorial.MainApplication.java -jar app.jar

#-Dspring.profiles.active=local