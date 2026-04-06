FROM eclipse-temurin:17-jdk-jammy

WORKDIR /opt/tracker_service

COPY target/*.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","app.jar"]