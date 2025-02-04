FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled jar file into the container
COPY target/mongo_app-0.0.1-SNAPSHOT.jar /app/mongo_app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "mongo_app.jar"]
