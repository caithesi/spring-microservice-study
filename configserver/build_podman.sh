#!/bin/bash

# Exit immediately if any command fails
set -e


./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true -DskipTests
# Only proceed to Docker steps if Maven build succeeded
echo "Maven build successful. Proceeding with Docker build..."

podman build  -t caithesi/ostock-config-service . \
  --build-arg  FINAL_JAR_NAME=app

echo "build image successfully, now, please push latest image to dockerhub at docker://docker.io/caithesi/ostock-licensing-service:latest
then go to https://dashboard.render.com/web/srv-d1dvlabipnbc73dou9d0/deploys/dep-d1dvlajipnbc73dou9ig to reload service
"

