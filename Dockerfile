FROM openjdk:11-jdk
WORKDIR /app
COPY . /app
RUN ./gradlew bootJar
