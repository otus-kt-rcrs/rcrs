FROM maven:3.8.3-openjdk-17

ARG JAR_FILE=target/*.jar

ENV SPRING_PROFILES_ACTIVE=dev

WORKDIR /app

COPY ${JAR_FILE} app.jar

COPY src/main/resources/application.yml application.yml

COPY src/main/resources/application-dev.yml application-dev.yml

COPY src/main/resources/application-prod.yml application-prod.yml

COPY src/main/resources/application-test.yml application-test.yml

EXPOSE 8080 8443

ENTRYPOINT ["java", "-jar", "app.jar"]