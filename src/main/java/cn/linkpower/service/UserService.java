package cn.linkpower.service;

import cn.linkpower.vo.User;

public interface UserService {
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	User queryUserById(Integer id);
	
	User queryUserById1(Integer id);
	
	User queryUserById2(Integer id);
	
	User updateUser(User user);

	void delUserById1(Integer id);

}
