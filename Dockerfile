FROM maven:latest
LABEL authors="entor"

WORKDIR /app
COPY pom.xml /app

COPY . /app

RUN mvn package

CMD ["java","-jar","target/in_class_assignment_1-1.0-SNAPSHOT.jar"]