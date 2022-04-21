#!/bin/bash
java -XX:+UseG1GC  -jar app.jar

export MONITORING_HOST=$(curl http://192.168.0.245/latest/meta-data/local-ipv4)

# -Djava.security.egd=file:/dev/./urandom -Dloader.main=MainApplication.java
# -Dspring.profiles.active=local