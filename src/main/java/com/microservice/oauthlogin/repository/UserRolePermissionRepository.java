package com.microservice.oauthlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.oauthlogin.entity.UserRole;
import com.microservice.oauthlogin.entity.UserRolePermission;

@Repository
public interface UserRolePermissionRepository extends JpaRepository<UserRolePermission, Long>{

	List<UserRolePermission> findUserRolePermissionByuserRole(UserRole rOLE);
	
	
}
