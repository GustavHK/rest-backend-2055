FROM openjdk:8

COPY rest-*.jar /restapi.jar

CMD ["java" , "-jar" , "/restapi.jar"]