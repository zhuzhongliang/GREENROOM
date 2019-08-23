package com.zzl.greenroom.module.code;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;


/**
 * @author zzl
 *
 */

public class User extends Model<User>{//继承Model接口 user对象可提供单表的curd功能
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private Integer id;
	private String name;
	private String accountId;
	private String token;
	private Long gmtCreate;
	private Long gmtModified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Long gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Long getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Long gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	
	
	
	
	
	
	
	
 }
