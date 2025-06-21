#!/bin/bash

# Exit immediately if any command fails
set -e

(
  cd ../.. || exit 1
  ./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true
)

# Only proceed to Docker steps if Maven build succeeded
echo "Maven build successful. Proceeding with Docker build..."

docker build -f ./Dockerfile -t ostock/licensing-service ../.. \
  --build-arg  FINAL_JAR_NAME=app

#docker run -it -p8080:8080 ostock/licensing-service
docker compose up