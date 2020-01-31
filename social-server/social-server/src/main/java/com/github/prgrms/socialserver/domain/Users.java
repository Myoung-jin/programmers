package com.github.prgrms.socialserver.domain;

import java.util.Date;

public class Users {
	private Integer seq;
	private String userId;
	private String email;
	private String passwd;
	private String loginCount;
	private Date lastLoginAt;
	private Date createAt;
	
	public Users() {
		super();
	}
	public Users(Integer seq, String userId,String email, String passwd, String loginCount, String lastLoginAt) {
		this.seq = (int) seq;
		this.userId = userId;
		this.email = email;
		this.passwd = passwd;
		this.loginCount = loginCount;
//		this.lastLoginAt = lastLoginAt;
	}
	public Users(String userId,String email, String passwd) {
		this.userId = userId;
		this.email = email;
		this.passwd = passwd;
	}
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}
	public Date getLastLoginAt() {
		return lastLoginAt;
	}
	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
}
