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
	$(DOCKER_COMPOSE) down --remove-orphans

.PHONY: all build-soap-service run-soap-service build-rest-service run-rest-service wait-for-soap-service clean