# SpringCloud-practice
### 互联网应用技术第二次团队作业 小组成员：姚子航，徐天强，应邦豪，王鑫伟，励颖
#### 应用到的组件：
+ Eureka server
+ Eureka client
+ Ribbon
+ Hystrix
+ Zuul
+ zipkin
+ Spring Boot actuator
#### 日志使用springboot默认的logback
#### 作业中共有五个工程
### 1.Eureka-server
使用Eureka实现的服务注册、发现中心，所有服务都在注册中心注册
### 2.Eureka-client
实际的服务提供者，提供了/service-info接口，功能是查看当前有多少服务注册到服务中心。
### 3.Service-consumer
服务消费者，使用Ribbon来做负载均衡，添加Hystrix断路器，当Eureka-client挂掉的时候，自动转到/error接口
### 4.Service-zuul
使用zuul实现的服务网关，提供访问各个服务的统一接口，隐藏服务真实接口。
### 5.Zipkin-server
使用zipkin实现的链路追踪服务器，Eureka-client与Service-consumer都在这里注册，可以查看调用的trace及服务间的依赖关系。
### 所有服务使用 SpringBoot Actuator提供监控端点
### 所有服务使用 Logback进行日志记录、管理
