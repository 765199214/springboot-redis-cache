package cn.linkpower.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class User implements Serializable {
	private static final long serialVersionUID = 3526560195700752585L;
	@ApiModelProperty("用户主键")
	private Integer id;
	@ApiModelProperty("用户名")
	private String userName;
	@ApiModelProperty("用户密码")
	private String passWord;
	@ApiModelProperty("创建日期")
	private Long createTimes;
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", createTimes=" + createTimes
				+ "]";
	}
	
	
}
