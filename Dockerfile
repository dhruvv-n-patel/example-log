FROM maven:3.8.4-openjdk-17-slim AS spring-build
COPY . /usr/src/app/example/
WORKDIR /usr/src/app/example/
ADD https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic.jar newrelic.jar
RUN mvn -f pom.xml clean package

# Stage 3: Combine React and Spring Boot apps
FROM maven:3.8.4-openjdk-17-slim
RUN mkdir -p /opt/app
RUN ls -ltr
COPY --from=spring-build /usr/src/app/example/target/example-0.0.1-1.jar /opt/app/app.jar
COPY --from=spring-build --chmod=777 /usr/src/app/example/newrelic.jar /opt/app/newrelic.jar
EXPOSE 8080
CMD ["java","-javaagent:/opt/app/newrelic.jar", "-jar", "/opt/app/app.jar"]
