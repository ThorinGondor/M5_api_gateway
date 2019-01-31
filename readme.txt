启动feign服务消费者项目后，请访问：http://localhost:5555/api-a/hello?accessToken=flyme
                                   http://localhost:5555/api-b/feign-consumer?accessToken=flyme
                                   http://localhost:5555/api-b/feign-consumer-expand?accessToken=flyme
                                   http://localhost:5555/api-c/hello?accessToken=flyme
本节构建了Spring Cloud Zuul网关，客户（我们）就可以在外部通过 Zuul 服务网关来访问 hello-service-cluster 和 feign-consumer 两个微服务应用
我们在properties文件对上述 hello-service-cluster 和 feign-consumer 两个微服务应用，分别定义了api-a和api-b两个路由映射它们

虽然说 feign-consumer 之前一直被当做消费者，但它本身的访问接口http://localhost:9001/feign-consumer也是服务者
等同于 Zuul 网关使得我们可以使用该接口使用 feign-consumer 的服务

注：在 Pom.xml 添加的Zuul网关依赖包不但包括核心zuul-core，也包括了ribbon、hystrix、actuator
    上述 URL 中的 ?accessToken=flyme 用于Zuul过滤器 AccessFilter，如果过滤成功则进行路由，如果过率失败则返回错误码

ATTENTION! 本项目我们也使用了yaml文件配置来代替之前的properties文件配置，yaml文件配置能够使得 Zuul 路由的路由有优先配置，properties文件被放到了bak文件作为备份

在 zuul 的 API 执行网关中，还支持forward形式的服务端跳转配置，只需要path和url配置的方式就能完成，则 /api-c/hello 会被之行为 /local/hello