FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/stream-position-*.jar /app/stream-position.jar
CMD ["java", "-Xmx200m", "-jar", "/app/stream-position.jar"]

EXPOSE 8080
