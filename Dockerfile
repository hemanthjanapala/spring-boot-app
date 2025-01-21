FROM openjdk:22-jdk
WORKDIR /dem-app
COPY target/new.jar dem-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/dem-app/dem-app.jar"]
