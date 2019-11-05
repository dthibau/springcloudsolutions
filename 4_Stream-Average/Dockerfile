FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/cloud-stream-*.jar /app/cloud-stream.jar
CMD ["java", "-Xmx200m", "-jar", "/app/cloud-stream.jar"]

EXPOSE 8080
