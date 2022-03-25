#!/bin/bash
java -XX:+UseG1GC  -jar app.jar

# -Djava.security.egd=file:/dev/./urandom -Dloader.main=MainApplication.java
#-Dspring.profiles.active=local