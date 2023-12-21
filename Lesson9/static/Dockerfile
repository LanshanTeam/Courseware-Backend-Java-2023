#依赖jdk17环境
FROM khipu/openjdk17-alpine

#对外暴露8081
EXPOSE 8081
#复制server-1.0-SNAPSHOT到docker容器中并命名为app.jar
ADD springboot_test-1.0-SNAPSHOT.jar app.jar
#执行命令
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar"]
