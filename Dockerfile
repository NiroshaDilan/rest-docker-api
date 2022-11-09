FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG APP_NAME="rest-docker-api"
ARG APP_VERSION="0.0.1"
ARG JAR_FILE="/build/libs/${APP_NAME}-${APP_VERSION}.jar"

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]