FROM openjdk:14
ADD restful-api.jar restful-api.jar
ADD sample-data.json sample-data.json
EXPOSE 8080
ENTRYPOINT ["java","-jar","restful-api.jar"]