FROM openjdk:17-alpine
ARG JAR_FILE=target/sarf-web-service-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]