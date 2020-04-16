package com.zdev.seriescalendar.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zdev.seriescalendar.auth.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

	public Role findRoleByName(String name);
	
}
