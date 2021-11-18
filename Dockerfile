FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar peoplecentral.jar
ENTRYPOINT ["java","-jar","/peoplecentral.jar"]