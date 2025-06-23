#!/bin/bash

./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true
# Only proceed to Docker steps if Maven build succeeded
echo "Maven build successful. Proceeding with Docker build..."

podman build  -t ostock/licensing-service . \
  --build-arg  FINAL_JAR_NAME=app

podman run --rm -p 8080:8080 ostock/licensing-service
