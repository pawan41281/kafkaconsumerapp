# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Add the application's jar to the image
COPY target/kafkaconsumerapp.jar kafkaconsumerapp.jar

ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=192.168.29.109:9092

# Command to execute the application
ENTRYPOINT ["java", "-jar", "kafkaconsumerapp.jar"]