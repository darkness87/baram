FROM openjdk:8-jdk-alpine
LABEL maintainer="darka87@kakao.com"
ADD target/baram-muhyul-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
VOLUME /tmp
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]
