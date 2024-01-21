FROM openjdk:17
WORKDIR /app
COPY ./target/Medicare.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Medicare.jar"]