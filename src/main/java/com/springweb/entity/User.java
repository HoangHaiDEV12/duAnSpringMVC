package com.springweb.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<UserRole> rloes = new HashSet<>();

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String passWord;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "createby")
	private String createBy;

	@Column(name = "modifyby")
	private String modifyBy;

	@Column(name = "createdate")
	private Date createDate;

	@Column(name = "modifydate")
	private Date modifyDate;
	
	@Column(name = "roleid")
	private int roleId;
	
	

	public User() {
		super();
	}

	public User(int userId, Set<UserRole> rloes, String userName, String passWord, String fullName, String email,
			String createBy, String modifyBy, Date createDate, Date modifyDate, int roleId, Set<UserRole> userS) {
		super();
		this.userId = userId;
		this.rloes = rloes;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
		this.createBy = createBy;
		this.modifyBy = modifyBy;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.roleId = roleId;
		
	}

	

	public Set<UserRole> getRloes() {
		return rloes;
	}

	public void setRloes(Set<UserRole> rloes) {
		this.rloes = rloes;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date date) {
		this.createDate = (Date) date;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(java.util.Date date) {
		this.modifyDate = (Date) date;
	}

}
