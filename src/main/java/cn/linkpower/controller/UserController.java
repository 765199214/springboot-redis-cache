package cn.linkpower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.linkpower.service.UserService;
import cn.linkpower.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("用户测试类")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userServiceImpl;
	
	@GetMapping("/getuser/{id}")
	@ApiOperation(value = "获取用户信息",notes = "queryUser")
	@ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "String")
	public User queryUser(@PathVariable(value = "id") String id) {
		log.info("----queryUser---id---{}",String.valueOf(id));
		return userServiceImpl.queryUserById1(Integer.parseInt(id));
	}
	
	@PostMapping("/updateUser")
	@ApiOperation(value = "修改用户信息",notes = "updateUser")
	//@ApiImplicitParam(name = "user", value = "用户信息", paramType = "body", required = true, dataType = "cn.linkpower.vo.User")
	public User updateUser( @RequestBody User user) {
		
		return userServiceImpl.updateUser(user);
	}
	
	@GetMapping("/deluser/{id}")
	@ApiOperation(value = "删除用户信息",notes = "delUser")
	@ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "String")
	public User delUser(@PathVariable(value = "id") Integer id) {
		log.info("----queryUser---id---{}",String.valueOf(id));
		userServiceImpl.delUserById1(id);
		return null;
	}
}
