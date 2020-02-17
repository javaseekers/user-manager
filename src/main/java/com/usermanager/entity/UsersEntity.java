package com.usermanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERS")
public @Data class UsersEntity {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE")
	private String mobile;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private Date createdate;

	@Column(name = "UPDATED_BY")
	private String updateBy;

	@Column(name = "UPDATED_DATE")
	private Date updatedate;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleEntity roleEntity;
}
