# Stage 1: Build React app
FROM node:14 AS react-build
WORKDIR /app
COPY ./react-app/ /app
RUN npm install
RUN npm run build

# Stage 2: Build Spring Boot app
FROM maven:3.8.3-jdk-11 AS spring-build
WORKDIR /app
COPY ./spring-boot-app/ /app
RUN mvn package -DskipTests

# Stage 3: Combine React and Spring Boot apps
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=spring-build /app/target/*.jar /app/app.jar
COPY --from=react-build /app/build /app/src/main/resources/static
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
