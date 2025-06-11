#!/bin/bash

(
  cd ../.. || exit 1
  ./mvnw clean package
)

#docker build -t ostock/licensing-service
docker build -f ./Dockerfile -t ostock/licensing-service ../..
#docker run -it -p8080:8080 ostock/licensing-service