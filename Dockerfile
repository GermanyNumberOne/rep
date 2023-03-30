FROM adoptopenjdk:11-jre-hotspot
COPY target/movie-list-project.jar movie-list-project.jar
ENTRYPOINT ["java", "-jar", "movie-list-project.jar"]