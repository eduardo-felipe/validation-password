FROM adoptopenjdk/openjdk11:alpine

ARG JAR_FILE=target/validation-password-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} validation-password.jar

CMD ["java", "-jar", "/validation-password.jar"]
