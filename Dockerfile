FROM openjdk:17-jdk-alpine

RUN mkdir -p /app

COPY target/restapi-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]