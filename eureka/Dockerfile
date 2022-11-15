FROM openjdk:17-ea-5-jdk-alpine3.13
COPY /eureka/target/eureka-0.0.1-SNAPSHOT.jar /usr/eureka-server.jar
WORKDIR /usr
EXPOSE 8761
CMD ["java", "-jar", "eureka-server.jar"]
