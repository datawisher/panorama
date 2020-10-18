# 基于镜像
FROM openjdk:8-jdk-alpine

# 将本地文件夹挂载到当前容器
VOLUME /tmp

# 复制文件到容器，也可以直接写成
ADD spring-cloud-eureka-1.0.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

# 声明需要暴露的端口
EXPOSE 8761

# 配置容器启动后执行的命令
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]