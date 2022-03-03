#!/bin/bash
java -Dspring.profiles.active=${PROFILE_ENV} -XX:+UseG1GC -Djava.security.egd=file:/dev/./urandom -Dloader.main=com.paytmlabs.adtech.adtechdecisionengine.AdTechDecisionEngineApplication.java -jar app.jar
