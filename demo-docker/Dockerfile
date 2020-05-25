# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="andrea.pacini@nttdata.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/@project.artifactId@-@project.version@.jar

# Add the application's jar to the container
ADD ${JAR_FILE} @project.artifactId@-@project.version@.jar

ADD config/application-COLL.properties application-COLL.properties
ADD config/application-PROD.properties application-PROD.properties

# Run the jar file
ENTRYPOINT ["java","-jar","/@project.artifactId@-@project.version@.jar"]
