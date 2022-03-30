FROM openjdk:8-alpine
ADD target/libere-ecommerce-challenge-0.0.1-SNAPSHOT.jar /usr/share/app.jar
MAINTAINER raqferna 
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]