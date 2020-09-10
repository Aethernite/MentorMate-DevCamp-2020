FROM adoptopenjdk/openjdk11

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} spring-simple-application.jar

ENTRYPOINT ["java","-jar","/spring-simple-application.jar"]
