FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY target/fake-load-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]