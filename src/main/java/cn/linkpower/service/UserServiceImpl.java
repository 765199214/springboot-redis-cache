package cn.linkpower.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.linkpower.dao.UserMapper;
import cn.linkpower.vo.User;

@Service
@Transactional
@CacheConfig(cacheNames = {"user"}) //提取注解公共属性
public class UserServiceImpl implements UserService {
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Cacheable( key = "#root.method")
	public User queryUserById(Integer userId) {
		log.error("----查询数据库----");
		return userMapper.queryUserById(userId);
	}
	
	@Override
	@Cacheable( key = "#userId")
	public User queryUserById1(Integer userId) {
		log.error("----查询数据库----");
		return userMapper.queryUserById(userId);
	}
	
	@Override
	@Cacheable( key = "#userId",condition = "#userId>1")
	public User queryUserById2(Integer userId) {
		log.error("----查询数据库----");
		return userMapper.queryUserById(userId);
	}
	
	@Override
	@CachePut(key = "#user.id")
	public User updateUser(User user) {
		log.error("----更新数据库----");
		userMapper.updateUser(user);
		log.info("id:{}",user.getId());
		return userMapper.queryUserById(user.getId()); 
	}

	@Override
	@CacheEvict(key = "#id")
	public void delUserById1(Integer id) {
		userMapper.delUserById1(id);
	}

}
