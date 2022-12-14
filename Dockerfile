FROM maven:3.8.4-jdk-11-slim as builder

RUN mkdir -p /home/project

COPY . /home/project

WORKDIR /home/project

RUN mvn install -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:alpine-jre as runtime

COPY --from=builder /home/project/target/*.jar /home/project/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/project/app.jar"]
