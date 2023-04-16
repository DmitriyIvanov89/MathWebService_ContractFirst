FROM openjdk:11
WORKDIR /app
COPY . /app
RUN ./mvnw clean install
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
CMD ["java", "-jar", "target/application.jar"]