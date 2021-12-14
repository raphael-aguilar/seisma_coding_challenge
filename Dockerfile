# First Stage
FROM maven:3.6.1-jdk-11 AS MAVEN_BUILD

COPY ./ ./

# Explicitly copy pom.xml, to solve an issue
COPY pom.xml pom.xml

# Now guaranteed to contain pom.xml, should work?
RUN mvn clean package

# Second stage
FROM openjdk:11

COPY --from=MAVEN_BUILD target/seisma_coding_challenge-1.0-SNAPSHOT.jar /program.jar

CMD ["java", "-jar", "/program.jar"]

# Add tax brackets
ADD src/taxBrackets.json src/taxBrackets.json
ADD taxBrackets.json taxBrackets.json

EXPOSE 8080
