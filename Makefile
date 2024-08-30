RECEITINHA_VERSION=latest

build:
	@./mvnw clean package

start:
	@echo "Starting containers..."
	RECEITINHA_VERSION=$(RECEITINHA_VERSION) docker-compose up -d

all: build start

stop:
	docker compose stop