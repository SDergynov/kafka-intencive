FROM openjdk:17-ea-5-jdk-alpine3.13
COPY /target/rest-service-0.0.1-SNAPSHOT.jar /usr/rest-service.jar
WORKDIR /usr
#RUN javac EducationService.java
EXPOSE 8080
CMD ["java", "-jar", "rest-service.jar"]
