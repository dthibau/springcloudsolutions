FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/annuaire*.jar /app/annuaire.jar
CMD ["java", "-Xmx200m", "-jar", "/app/annuaire.jar","--spring.profiles.active=docker"]

EXPOSE 1111
