FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/members-service.jar /app/
ADD ./wait-for-it.sh /
RUN chmod +x wait-for-it.sh
CMD ["java", "-Xmx200m", "-jar", "/app/members-service.jar","--spring.profiles.active=docker"]

EXPOSE 8888
