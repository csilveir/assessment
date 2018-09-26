FROM openjdk:jre-slim

RUN mkdir /tmp/app

ADD build/libs/*.jar /tmp/app

RUN mv /tmp/app/*.jar /tmp/app/app.jar

ENV PROFILE=""

ENTRYPOINT [ "sh", "-c", "java $PROFILE -Djava.security.egd=file:/dev/./urandom -jar /tmp/app/app.jar" ]
