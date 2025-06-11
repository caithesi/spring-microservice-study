#!/bin/bash

(
  cd .. || exit 1
  ./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true
)

docker build -t ostock/licensing-service ../..

docker run -it -p8080:8080 ostock/licensing-service