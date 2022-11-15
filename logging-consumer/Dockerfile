FROM openjdk:17-ea-5-jdk-alpine3.13
COPY /logging-consumer/target/logging-consumer-0.0.1-SNAPSHOT.jar /usr/logging-consumer.jar
WORKDIR /usr
CMD ["java", "-jar", "logging-consumer.jar"]
