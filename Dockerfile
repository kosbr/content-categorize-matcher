FROM openjdk:17-jdk-alpine
COPY build/libs/category-matcher.jar /deployments/category-matcher.jar
USER 185
ENV JAVA_OPTS="-Xmx512m"
ENTRYPOINT ["java","-jar","/deployments/category-matcher.jar"]