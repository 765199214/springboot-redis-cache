package cn.linkpower.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching  // 开启缓存
public class RedisConfig {
	
	/**
	 * 重写Redis序列化定义方式，采取json方式————避免json格式乱码
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		// 创建json序列化对象
		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
		// 设置key序列化String
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		// 设置value序列化 json
		redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
		// 设置hash key序列化String
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// 设置hash value 序列化json
		redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
		
		// 初始化redis完成序列化的方法
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	/**
	 * 缓存配置
	 * @param factory
	 * @return
	 */
	@Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration cacheConfiguration =
        		RedisCacheConfiguration.defaultCacheConfig()
        				//设置缓存默认超时时间  30分钟
        				//.entryTtl(Duration.ofMillis(30))
                        .disableCachingNullValues()
                        // 设置key序列化  
                        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();

    }
	
}
