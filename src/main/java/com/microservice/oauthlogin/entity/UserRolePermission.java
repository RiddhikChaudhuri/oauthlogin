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
    private long id;
	
	@Column(name = "userrolepermission")
    private String userRolePermission;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roleid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserRole userRole;


	public UserRolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
