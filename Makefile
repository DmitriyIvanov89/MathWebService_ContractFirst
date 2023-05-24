DOCKER_COMPOSE = docker compose
SOAP_SERVICE = soap_service
REST_SERVICE = rest_service

all: build-soap-service run-soap-service build-rest-service run-rest-service

build-soap-service:
	@echo "Starting build soap_service..."
	cd SoapService/ && ./mvnw clean install
	$(DOCKER_COMPOSE) build $(SOAP_SERVICE)
	@echo "Finish build soap_service ..."

run-soap-service:
	@echo "Starting soap_service ..."
	$(DOCKER_COMPOSE) up -d $(SOAP_SERVICE)

build-rest-service: wait-for-soap-service
	@echo "Starting build rest_service..."
	cd RESTClient/ && ./mvnw clean install
	$(DOCKER_COMPOSE) build $(REST_SERVICE)
	@echo "Finish build rest_service..."

run-rest-service:
	@echo "Starting soap_service ..."
	$(DOCKER_COMPOSE) up -d $(REST_SERVICE)

wait-for-soap-service:
	@echo "Waiting for SOAP service to start..."
	@while ! nc -z localhost 8080; do sleep 1; done
	@echo "SOAP service is up and running!"

clean:
	$(DOCKER_COMPOSE) down
	cd SoapService/ && ./mvnw clean
	cd RESTClient/ && ./mvnw clean

stop-running-services:
	$(DOCKER_COMPOSE) stop

start-builded-services:
	$(DOCKER_COMPOSE) start

build-local-services: build-soap-service-local run-soap-service-local build-rest-service-local run-rest-service-local

build-soap-service-local:
	@echo "Starting build soap_service..."
	cd SoapService/ && ./mvnw clean install

run-soap-service-local:
	cd SoapService/ && nohup java -jar target/SoapService.jar &

build-rest-service-local: wait-for-soap-service
	@echo "Starting build rest_service..."
	cd RESTClient/ && ./mvnw clean install

run-rest-service-local:
	cd RESTClient/ && nohup java -jar target/RESTClient.jar &

clean-services:
	@echo "Starting clean soap_service..."
	cd SoapService/ && ./mvnw clean
	@echo "Starting clean rest_service..."
	cd RESTClient/ && ./mvnw clean

.PHONY: all build-soap-service run-soap-service build-rest-service run-rest-service wait-for-soap-service clean stop-running-services start-builded-services clean-services build-local-services build-soap-service-local run-soap-service-local build-rest-service-local run-rest-service-local