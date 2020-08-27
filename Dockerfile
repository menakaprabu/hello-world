FROM openjdk:8-jdk-alpine
ADD /build/libs/helloworld-0.0.1.jar helloworld-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "helloworld-0.0.1.jar"]
