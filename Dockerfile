# syntax=docker/dockerfile:1
FROM openjdk:17-alpine3.14

VOLUME /app
ADD target/mos-context-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]