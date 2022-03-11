#!/bin/bash
java -XX:+UseG1GC  -jar app.jar

# -Djava.security.egd=file:/dev/./urandom -Dloader.main=com.springboot.tutorial.MainApplication.java
#-Dspring.profiles.active=local