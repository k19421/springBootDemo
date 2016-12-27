# 支持redis
1、 在pom文件中添加对redis的支持，添加如下的代码
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

2、 在resources/application.yml中配置redis的连接信息（如果不配是去连接localhost:6379的redis）
```
spring:
  redis:
    host: localhost
    port: 6379
```

3、 写代码
```java
@Autowired
private StringRedisTemplate template;
public void run(String... strings) throws Exception {
	ValueOperations<String, String> stringStringValueOperations = template.opsForValue();
	stringStringValueOperations.set("test.key", "sssssssss");
	System.out.println("get key from redis:" + stringStringValueOperations.get("test.key"));
}
```

4、 运行连接redis成功