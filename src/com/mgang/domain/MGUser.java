package com.mgang.domain;

import java.util.Date;

/**
 * 
 * @author meigang
 * user实体，对应数据库的user表
 */
public class MGUser {
	private Integer id;
	private String userName;
	private String nickName;
	private String password;
	private Date addTime;
	private Integer loginCount;
	
	public MGUser(){}
	//生成构造函数
	public MGUser(String userName, String nickName, String password,
			Date addTime, Integer loginCount) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.addTime = addTime;
		this.loginCount = loginCount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	
	@Override
	public String toString() {
		return "MGUser [id=" + id + ", userName=" + userName + ", nickName="
				+ nickName + ", password=" + password + ", addTime=" + addTime
				+ ", loginCount=" + loginCount + "]";
	}
	
}
