FROM openjdk:17-ea-5-jdk-alpine3.13
COPY /track-consumer/target/track-consumer-0.0.1-SNAPSHOT.jar /usr/track-consumer.jar
WORKDIR /usr
CMD ["java", "-jar", "track-consumer.jar"]
