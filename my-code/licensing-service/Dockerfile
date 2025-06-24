#stage 1
FROM eclipse-temurin:21 AS build

ARG FINAL_JAR_NAME="app1"

LABEL maintainer="Cai The Si <caithesi@gmail.com>"

COPY ./target/${FINAL_JAR_NAME}.jar ./app.jar
RUN java -Djarmode=tools -jar ./app.jar extract --layers --launcher

#RUN java -Djarmode=tools -jar ./app.jar extract

#stage 2
FROM eclipse-temurin:21-jre

COPY --from=build /dependencies/ ./
COPY --from=build /spring-boot-loader/ ./
COPY --from=build /snapshot-dependencies/ ./
COPY --from=build /application/ ./

# Use the new launcher class for Spring Boot 3.2+
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]