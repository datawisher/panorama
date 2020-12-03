# 基于镜像
FROM openjdk:8-jdk-alpine
MAINTAINER Jim Han <datawisher@gmail.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar