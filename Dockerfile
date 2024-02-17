FROM maven:3.8.6-openjdk-11 AS spring-build
COPY . /usr/src/app/example/
WORKDIR /usr/src/app/example/
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.32.0/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
RUN mvn -f pom.xml clean package

# Stage 3: Combine React and Spring Boot apps
FROM openjdk:11-jre-slim
RUN mkdir -p /opt/app
RUN ls -ltr
COPY --from=spring-build /usr/src/app/example/target/example-0.0.1-1.jar /opt/app/app.jar
COPY --from=spring-build --chmod=777 /usr/src/app/example/opentelemetry-javaagent.jar /opt/app/opentelemetry-javaagent.jar
EXPOSE 8080
CMD ["java","-javaagent:/opt/app/opentelemetry-javaagent.jar", "-jar", "/opt/app/app.jar"]
