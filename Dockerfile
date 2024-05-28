FROM eclipse-temurin:21-jdk
RUN mkdir -p /receitinha
WORKDIR /receitinha
COPY target/api-0.0.1-SNAPSHOT.jar receitinha-api.jar
ENTRYPOINT ["java", "-jar","receitinha-api.jar"]
