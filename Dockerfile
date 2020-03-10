FROM maven:3.6.2-jdk-11-slim AS build  
WORKDIR /usr/src/app  

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src  

RUN mvn clean package -DskipTests

FROM openjdk:11.0.4-jre-slim
COPY --from=build /usr/src/app/target/demo-0.0.1-SNAPSHOT.jar /usr/app/demo-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/demo-0.0.1.jar","--server.port=8080"]