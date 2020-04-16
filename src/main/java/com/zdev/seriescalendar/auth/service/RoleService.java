package com.zdev.seriescalendar.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdev.seriescalendar.auth.model.Role;
import com.zdev.seriescalendar.auth.repository.RoleRepository;

@Service
public class RoleService {
	
	public RoleRepository roleRepository;
	
	@Autowired
	public RoleService(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}
	
	public Role findUserRole() {
		return this.roleRepository.findRoleByName("ROLE_USER");
	}

}
