FROM openjdk:11
VOLUME /app
ADD target/tutorial-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
COPY entrypoint.sh /
ENTRYPOINT ["/entrypoint.sh"]