#!/bin/bash

# Exit immediately if any command fails
set -e

./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true
# Only proceed to Docker steps if Maven build succeeded
echo "Maven build successful. Proceeding with Docker build..."

docker build  -t ostock/licensing-service . \
  --build-arg  FINAL_JAR_NAME=app
