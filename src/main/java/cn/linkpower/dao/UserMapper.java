package cn.linkpower.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.linkpower.vo.User;

@Mapper
public interface UserMapper {
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	@Select("select id,userName,passWord,createTimes from user where id = #{id}")
	User queryUserById(Integer id);
	
	void updateUser(User user);
	
	@Delete("delete from user where id = #{id}")
	void delUserById1(Integer id);
}
