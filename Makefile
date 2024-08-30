RECEITINHA_VERSION="$(shell ./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout | grep -v Warning)"

build:
	@./mvnw clean package

start:
	@echo "Starting containers..."
	RECEITINHA_VERSION=$(RECEITINHA_VERSION) docker-compose up -d

all: stop build start

stop:
	docker compose stop