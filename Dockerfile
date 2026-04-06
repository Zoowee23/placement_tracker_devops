FROM eclipse-temurin:17-jdk-jammy

WORKDIR /opt/tracker_service

COPY target/placement-tracker-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]