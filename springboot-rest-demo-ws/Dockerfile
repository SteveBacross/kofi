FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE  8080
