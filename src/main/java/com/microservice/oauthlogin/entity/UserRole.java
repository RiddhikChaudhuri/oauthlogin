package com.microservice.oauthlogin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class UserRole {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "roleid")
    private long id;
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Column
	private String roleName;
	
    @Column(name = "userrolepermission")
    private String userRolePermission;



	public String getUserRolePermission() {
		return userRolePermission;
	}



	public void setUserRolePermission(String userRolePermission) {
		this.userRolePermission = userRolePermission;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((userRolePermission == null) ? 0 : userRolePermission.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (id != other.id)
			return false;
		if (userRolePermission == null) {
			if (other.userRolePermission != null)
				return false;
		} else if (!userRolePermission.equals(other.userRolePermission))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userRolePermission=" + userRolePermission + "]";
	}



	public UserRole(long id, String userRolePermission) {
		super();
		this.id = id;
		this.userRolePermission = userRolePermission;
	}

	

}
