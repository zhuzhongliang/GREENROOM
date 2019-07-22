package com.zzl.greenroom.module.system.pojo;

import java.util.Date;

/**
 * @author zzl
 *    用户登陆信息表
 * @since 2019-7-20
 */
/**
 * @author Administrator
 *
 */
public class User {
	
	
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 头像
	 */
	private String headImage;
	/**
          * 密码
     */
	private String password;
    /**
     * md5密码盐
     */
	private String salt;
	/**
	 * 生日
     */
	private Date birthday;
    /**
           * 性别（1：男 2：女）
     */
	private Integer sex;
    /**
            * 电子邮件
     */
	private String email;
    /**
             * 电话
     */
	private String phone;
    /**
            * 角色id
     */
	private String roleid;
    /**
             * 部门id
     */
	private Integer deptid;
    /**
              * 状态(1：启用  2：冻结  3：删除）
     */
	private Integer status;
    /**
            * 创建时间
     */
	private Date createtime;
    /**
              * 保留字段
     */
	private Integer version;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", headImage=" + headImage + ", password="
				+ password + ", salt=" + salt + ", birthday=" + birthday + ", sex=" + sex + ", email=" + email
				+ ", phone=" + phone + ", roleid=" + roleid + ", deptid=" + deptid + ", status=" + status
				+ ", createtime=" + createtime + ", version=" + version + "]";
	}
	
	
	
	
	 
	
}
