FROM maven:3.8.5-openjkd-17 AS build
COPY ..
RUN maven clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/ecommerce-0.0.1-SNAPSHOT.jar ecommerce.jar
ENTRYPOINT ["java", "-jar", "ecommerce.jar"]