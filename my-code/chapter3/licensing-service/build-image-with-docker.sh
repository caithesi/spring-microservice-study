mvn clean package

docker build -t ostock/licensing-service .

docker run -it -p8080:8080 ostock/licensing-service