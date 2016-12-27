package com.fcbox.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置redis
 * Created by 000498 on 2016/11/10.
 */
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate template = new RedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		//设置key String序列化 如果不设置默认jdk序列化
		StringRedisSerializer keySerializer = new StringRedisSerializer();
		template.setKeySerializer(keySerializer);

//		//设置value json序列化 如果不设置默认jdk序列化
//		Jackson2JsonRedisSerializer valueSerializer = new Jackson2JsonRedisSerializer(Object.class);
//		ObjectMapper om = new ObjectMapper();
//		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//		valueSerializer.setObjectMapper(om);
//		template.setValueSerializer(valueSerializer);
//
		return template;
	}
}
