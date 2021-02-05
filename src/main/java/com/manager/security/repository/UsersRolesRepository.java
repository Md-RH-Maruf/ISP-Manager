package com.manager.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.security.entity.UsersRoles;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Long>{
	List<UsersRoles> findByUserId(Long userId);
}
