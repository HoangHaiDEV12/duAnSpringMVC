package com.springweb.entity;


import java.sql.Date;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role   {

	@Id
	@Column(name = "roleid")
	private int roleId;
	
	
	@Column(name = "rolename")
	private String roleName;

	@Column(name = "createby")
	private String createBy;

	@Column(name = "createdate")
	private Date createDate;

	@Column(name = "modifyby")
	private String modifyBy;

	@Column(name = "modifydate")
	private Date modifyDate;

	
	
	

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, Set<UserRole> userS, String roleName, String createBy, Date createDate, String modifyBy,
			Date modifyDate) {
		super();
		this.roleId = roleId;
	
		this.roleName = roleName;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date date, Date createDate) {
		this.createDate = createDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(java.util.Date date, Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
