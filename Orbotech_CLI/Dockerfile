FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Orbotech_CLI.jar
ENTRYPOINT ["java","-jar","/Orbotech_CLI.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/*.jar Orbotech_CLI.jar
#ENTRYPOINT ["java", "-jar", "/Orbotech.jar"]