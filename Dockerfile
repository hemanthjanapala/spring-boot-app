# FROM openjdk:22-jdk
# WORKDIR /dem-app
# COPY target/new.jar dem-app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/dem-app/dem-app.jar"]

# Step 1: Use Maven base image to build the application
FROM maven:3.8.7-openjdk-17 as builder
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the application (JAR file)
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight image to run the application
FROM openjdk:17-jdk
WORKDIR /dem-app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/dem-app.jar dem-app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/dem-app/dem-app.jar"]

