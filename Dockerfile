FROM eclipse-temurin:17-jdk-alpine
COPY target/logout-system-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
