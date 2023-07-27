FROM adoptopenjdk/openjdk17

EXPOSE 8080

COPY /target/active_edge_accessment_app-0.0.1-SNAPSHOT.jar /opt

##Command to run the jar in the container
CMD ["java", "-jar", "/opt/active_edge_accessment_app-0.0.1-SNAPSHOT.jar"]

