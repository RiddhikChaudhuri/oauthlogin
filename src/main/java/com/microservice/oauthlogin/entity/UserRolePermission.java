package com.microservice.oauthlogin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLESPERMISSION")
public class UserRolePermission {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "permissionid")
	@JsonIgnore
    private long id;
	
	@Column(name = "userrolepermission")
    private String userRolePermission;

	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roleid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserRole userRole;


	public UserRolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUserRolePermission() {
		return userRolePermission;
	}


	public void setUserRolePermission(String userRolePermission) {
		this.userRolePermission = userRolePermission;
	}


	public UserRole getUserRole() {
		return userRole;
	}


	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	
}
