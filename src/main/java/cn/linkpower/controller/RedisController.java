package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.linkpower.vo.User;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping("/setVal")
	public String setVal(String key,String val) {
		redisTemplate.opsForValue().set(key, val);
		return "ok";
	}
	
	@RequestMapping("/getUser")
	public User getUser(String key) {
		User user = (User) redisTemplate.opsForValue().get(key);
		return user;
	}
}	
