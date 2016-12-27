package com.fcbox;

/**
 * Application
 * Created by 000498 on 2016/11/10.
 */

import com.fcbox.mapper.UserMapper;
import com.fcbox.mapper.UserXmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * springboot启动类
 * Created by 01108334 on 2016/8/19.
 */
@SpringBootApplication
//如果需要配置xml的话（比如dubbo）打开下面的配置
//@ImportResource("classpath:application-context.xml")
public class Application  implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserXmlMapper userXmlMapper;

	@Autowired
	RedisTemplate redisTemplate;

	public void run(String... strings) throws Exception {
		String userId = userMapper.queryEdmUserId("15680908680");
		log.info("userMapper.queryEdmUserId return:{}", userId);
		String userId1 = userXmlMapper.queryEdmUserId("15680908680");
		log.info("userXmlMapper.queryEdmUserId return:{}", userId1);

		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.set("testRedis", "testRedis");
		Object testRedis = opsForValue.get("testRedis");
		log.info("testRedis:{}", testRedis);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args).close();
	}
}
