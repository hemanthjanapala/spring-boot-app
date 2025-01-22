# FROM openjdk:22-jdk
# WORKDIR /dem-app
# COPY target/new.jar dem-app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/dem-app/dem-app.jar"]


# FROM maven:4.0-openjdk-21 as builder
# WORKDIR /app
#
# COPY . .
#
# RUN mvn clean package -DskipTests
#
# FROM openjdk:17-jdk
# WORKDIR /dem-app
# COPY --from=builder /app/target/dem-app.jar dem-app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/dem-app/dem-app.jar"]
# # Use a base OpenJDK image

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/my-springboot-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

