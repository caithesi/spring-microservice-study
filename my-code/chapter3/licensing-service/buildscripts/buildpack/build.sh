#!/bin/bash

# i personally dont recommend using this due to hard to custom and build optimized image
(
  cd ../.. || exit 1
  ./mvnw spring-boot:build-image
)
