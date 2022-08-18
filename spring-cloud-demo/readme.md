### Spring Cloud 示例项目
#### 项目介绍
**基础类库：**

```yaml
spring-cloud-api
```

**Eureka：**

```yaml
spring-cloud-consumer

spring-cloud-consumer-feign

spring-cloud-provider
```

**Eureka 注册中心：**

```yaml
spring-cloud-eureka-server
```

**服务网关：**

```yaml
spring-cloud-zuul
```

**配置中心：**

```yaml
# 配置中心服务端
spring-cloud-config-server
# 配置中心客户端
spring-cloud-config-client
# eureka 配置
spring-cloud-config-eureka
# 服务端配置
spring-cloud-config-provider
# 消费端配置
spring-cloud-config-consumer
```

**熔断降级：**

```yaml
spring-cloud-consumer-hystrix-dashboard

spring-cloud-provider-hystrix
```

**consul：**

```yaml
spring-cloud-provider-consul

spring-cloud-consumer-consul
```

**nacos：**
```yaml
spring-cloud-consumer-nacos

spring-cloud-provider-nacos
```

**消息总线：**

```yaml
# 暂未实现
spring-cloud-bus 
```

#### 环境配置
host
```shell
# dev
127.0.0.1	spring-cloud-eureka-9001
127.0.0.1	spring-cloud-eureka-9002
127.0.0.1	spring-cloud-eureka-9003
```
#### 启动集群
#### 提供者
```shell
java -jar spring-cloud-provider-1.0-SNAPSHOT.jar --server.port=8001
java -jar spring-cloud-provider-1.0-SNAPSHOT.jar --server.port=8002
java -jar spring-cloud-provider-1.0-SNAPSHOT.jar --server.port=8003
```
#### 消费者
```shell
java -jar spring-cloud-consumer-1.0-SNAPSHOT.jar --server.port=8001
java -jar spring-cloud-consumer-1.0-SNAPSHOT.jar --server.port=8002
java -jar spring-cloud-consumer-1.0-SNAPSHOT.jar --server.port=8003
```
启动脚本 `start.sh`
```shell

#!/bin/sh
# 
# 启动 jar 运行

# 项目部署目录
projectDir=/opt/springcloud/
# 项目运行 jar 名称
jarName="spring-cloud-demo.jar"
# 脚本日志目录
logDir=/var/log/springclouddemo/
# 项目部署环境
profileActive=dev

# 这里的 -x 参数判断 ${logDir} 是否存在并且是否具有可执行权限 
if [ ! -x "${logDir}" ]; then 
  mkdir -p "${logDir}" 
fi 

# 判断项目 SpringBoot 程序是否运行
count=$(ps -ef |grep ${jarName} |grep -v "grep" |wc -l)
if [ ${count} -lt 1 ]; then
    cd ${projectDir}
    nohup java -jar ${jarName} --spring.profiles.active=${profileActive} > /dev/null 2>&1 &
    echo "$(date '+%Y-%m-%d %H:%M:%S') 启动 ${jarName} 程序 ... ..." >> ${logDir}$(date "+%Y-%m-%d").log    
else
    echo "$(date '+%Y-%m-%d %H:%M:%S') ${jarName} 程序运行正常 !!! !!!" >> ${logDir}$(date "+%Y-%m-%d").log
fi

```
停止脚本 `stop.sh`
```shell

#!/bin/sh
# 
# 停止 jar 运行

# 项目部署目录
projectDir="/opt/springboot/"
# 项目运行 jar 名称
jarName="spring-cloud-demo.jar"
# 脚本名称
scriptName="stop.sh"


# 判断项目 SpringBoot 程序是否运行
count=$(ps -ef |grep ${jarName} |grep -v "grep" |wc -l)
if [ ${count} -gt 0 ]; then
    echo "已经存在 ${count} 个${jarName} 程序在运行"
    # 获取正在运行的程序进程 id(排除 grep 本身、awk 命令以及脚本本身)
    jarPid=$(ps x | grep ${jarName} | grep -v grep | grep -v '${scriptName}' | awk '{print $1}')
    # 停止正在运行的项目进程 
    kill -9 ${jarPid}
    output=`echo "正在关闭 ${jarName} 程序，进程 d: ${jarPid}"`
    echo ${output}
    
else
    echo '没有对应的程序在运行'
fi

# 删除 jar 包
rm -rf ${projectDir}${jarName}
# 进入 项目部署目录
cd ${projectDir}

```
