FROM eclipse-temurin:21-jdk
RUN mkdir -p /ps5
WORKDIR /ps5
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]