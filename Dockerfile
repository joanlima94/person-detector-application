# Etapa 1: Compilar o aplicativo com Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY . .

COPY src ./src

RUN mvn clean package -DskipTests

FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY --from=build /app/target/person-detector-application.jar app.jar

EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql_host:3306/test
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=123

ENTRYPOINT ["java", "-jar", "app.jar"]
