#! /bin/bash

docker compose -f deployments/database/docker-compose.yaml up -d
docker compose -f deployments/mqtt-broker/docker-compose.yaml up -d
docker compose -f deployments/spark/docker-compose.yml up -d


