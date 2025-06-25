#!/bin/bash

# Exit immediately if any command fails
set -e


./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true -DskipTests
# Only proceed to Docker steps if Maven build succeeded
echo "Maven build successful. Proceeding with Docker build..."

podman build  -t caithesi/ostock-licensing-service . \
  --build-arg  FINAL_JAR_NAME=app

