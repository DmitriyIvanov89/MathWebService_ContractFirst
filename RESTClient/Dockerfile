FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
ENV SOAP_ENDPOINT_URL=http://localhost:8080/services/math.wsdl
COPY ${JAR_FILE} app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "-Dspring-boot.run.arguments=--soap.wsdlLocation=${SOAP_ENDPOINT_URL}", "/app.jar"]