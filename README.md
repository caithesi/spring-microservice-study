**study spring microservice base on the book spring micro service in action, 2nd edittion

i created build script for either docker or podman

in case run with podman, make sure 

go to
/etc/containers/registries.conf

unqualified-search-registries = ["docker.io"]

to use the same docker file


or can config to run temporary

## example for vault podman

podman run -d -p 8200:8200 --name vault -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' hashicorp/vault

http://0.0.0.0:8200/ui/vault/auth**

## example source : https://github.com/carnellj/native_cloud_apps
## example code that modified alot https://github.com/wuyichen24/spring-microservices-in-action/tree/master


## Spring Microservices - Do with the book Spring Microservices in Action - Second Edition.

## Introduction

My own code from the book Spring Microservices in Action - Second Edition Manning publication book.

## Initial Configuration

1.	Apache Maven (http://maven.apache.org)
2.	Git Client (http://git-scm.com)

## How To Use

To clone and run this application, you'll need [Git](https://git-scm.com), [Maven](https://maven.apache.org/), [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html). From your command line:

### At local env
i use intellj, with java and maven installed to develop, this was developed with java 21, maven 4.0.RC, but mvnw was under 3.9.6


### run with cli
```bash
# Clone this repository
$ git clone ...

# Go into the repository
$ cd ...

# Install dependencies
$ ./mvnw install

# Run the app
$ ./mvnw spring-boot:run
or 
$ java -jar target/licensing-service-0.0.1-SNAPSHOT.jar
```

### run with docker
this is not encouraged when you are at local development, due to it make bad development experience

to run with docker, check folder buildscript

### test
both my machines are too old, so i use python to test instead, check testing folder, read readme for more information