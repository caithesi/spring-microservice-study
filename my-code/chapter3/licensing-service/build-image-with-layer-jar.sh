./mvnw clean package -DappFinalName=app -Dspring-boot.layers.enabled=true

docker build -f Dockerfile_layerJar -t ostock/licensing-service .

docker run -it -p8080:8080 ostock/licensing-service