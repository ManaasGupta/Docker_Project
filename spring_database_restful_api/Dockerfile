# Use a base image with JDK and Maven pre-installed
FROM maven:3.8.4-openjdk-17 AS builder

# Including Meta Data

LABEL author="Manas Gupta"
LABEL Date="29/02/2024"

# Set the working directory in the container
WORKDIR /usr

# Copy the Maven executable JAR file and the settings.xml file
COPY . /usr

# Build the application
RUN mvn clean package -DskipTests

# Use a smaller base image for the runtime environment
FROM openjdk:17.0.1-slim

# Set the working directory in the container
WORKDIR /usr

# Copy the JAR file from the builder stage to the runtime image
COPY --from=builder /usr/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 9091

# Command to run the application
CMD ["java", "-jar", "app.jar"]