FROM openjdk:jre-slim

RUN mkdir /tmp/app

ADD build/libs/*.jar /tmp/app

RUN mv /tmp/app/*.jar /tmp/app/app.jar


ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /tmp/app/app.jar" ]
