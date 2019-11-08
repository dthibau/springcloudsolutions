FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*
ADD ./target/config.jar /app/config.jar
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 8888
