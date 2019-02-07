FROM openjdk:11-jre-slim

RUN mkdir /tmp/app

ADD build/libs/*.jar /tmp/app

RUN mv /tmp/app/*.jar /tmp/app/app.jar

ENV SPRING_PROFILES_ACTIVE prd


ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /tmp/app/app.jar" ]
