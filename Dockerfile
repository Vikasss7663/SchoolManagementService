FROM openjdk:8-jdk-alpine
VOLUME /app
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
COPY entrypoint.sh /
ENTRYPOINT ["/entrypoint.sh"]