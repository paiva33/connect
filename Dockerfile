FROM openjdk:8-jdk-alpine

WORKDIR /app

EXPOSE 8080

ADD connect-application/target/connect-application-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["sh", "-c", "java -jar /app/connect-application-0.0.1-SNAPSHOT.jar"]