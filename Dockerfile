FROM openjdk:11

RUN mkdir /app

COPY ./target/tgbot-1.jar /app

WORKDIR ./USR/LOCAL/OPENJDK-11/BIN

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/tgbot-1.jar"]