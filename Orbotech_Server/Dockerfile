FROM eclipse-temurin:17-jdk-alpine
#EXPOSE 9090
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Orbotech_Server.jar
ENTRYPOINT ["java","-jar","/Orbotech_Server.jar"]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/*.jar Orbotech_Server.jar
#ENTRYPOINT ["java", "-jar", "/Orbotech_Server.jar"]