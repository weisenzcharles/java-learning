# Dockerfile
# 该镜像需要依赖的基础镜像
FROM java:8 as builder
# 将当前目录下的 jar 包复制到 docker 容器的`/`目录下
ADD target/spring-cloud-provider-1.0-SNAPSHOT.jar /spring-cloud-provider.jar
# 运行过程中创建一个 spring-cloud-provider.jar 文件
RUN bash -c 'touch /spring-cloud-provider.jar'
# 声明服务运行在 8080 端口
EXPOSE 8080
# 指定 docker 容器启动时运行 jar 包
ENTRYPOINT ["java", "-jar","/spring-cloud-provider.jar"]
# 指定维护者的名字
MAINTAINER charles zhang