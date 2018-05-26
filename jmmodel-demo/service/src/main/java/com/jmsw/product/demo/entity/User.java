package com.jmsw.product.demo.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

/**
 * 用户
 */
public class User implements Serializable {
	private static final long serialVersionUID = -2312110729335920029L;


	@ApiModelProperty(value="用户ID")
	@Id
	private Integer id;

	@ApiModelProperty(value="用户名")
	private Integer username;

	@ApiModelProperty(value="真实姓名")
	private String realName;

	@ApiModelProperty(value="状态")
	private Integer status;

	@ApiModelProperty(value="创建时间(yyyy-MM-dd)")
	private String createTime;

	@ApiModelProperty(value="更新时间(yyyy-MM-dd)")
	private String updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realName=" + realName + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
