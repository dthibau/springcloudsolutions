FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/document-service.jar /app/document-service.jar
CMD ["java", "-Xmx200m", "-jar", "/app/document-service.jar","--spring.profiles.active=docker"]

EXPOSE 3333
