FROM openjdk:11-jdk-slim
WORKDIR /app
COPY . /app
RUN ./gradlew bootJar
EXPOSE 8080
CMD java -jar -Dspring.porifles.active=local build/libs/bankos-0.0.1-SNAPSHOT.jar
