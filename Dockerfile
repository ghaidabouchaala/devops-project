FROM openjdk:8-jdk-alpine
EXPOSE 4200
ADD ./target/demo-0.0.1-SNAPSHOT.jar devopsProject.jar
ENTRYPOINT ["java","-jar","./demo-0.0.1-SNAPSHOT.jar"]
