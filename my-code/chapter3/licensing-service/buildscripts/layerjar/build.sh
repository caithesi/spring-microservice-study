#!/bin/bash

(
  cd ../.. || exit 1
  ./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true
)

docker build -f ./Dockerfile -t ostock/licensing-service ../.. \
  --build-arg  FINAL_JAR_NAME=app

#docker run -it -p8080:8080 ostock/licensing-service
docker compose up