FROM openjdk:8-jre-alpine
VOLUME /tmp

COPY target/*.jar app.jar
ENTRYPOINT ["java","-Xmx128m","-jar","/app.jar"]

EXPOSE 1111