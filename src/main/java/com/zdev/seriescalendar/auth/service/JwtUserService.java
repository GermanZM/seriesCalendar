package com.zdev.seriescalendar.auth.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zdev.seriescalendar.auth.model.CustomUser;
import com.zdev.seriescalendar.auth.model.Role;
import com.zdev.seriescalendar.auth.repository.UserRepository;



/**
 * Capa de negocio, es la encargada de realizar las validaciones
 * UserDetailsService -- Es usada por DAOAuthenticationProvider para la carga de los usuarios en el proceso de login.
 * @author German
 */
@Service
public class JwtUserService implements UserDetailsService {
	
	public UserRepository userRepository;
	public RoleService roleService;
	
	@Autowired
	public JwtUserService(UserRepository userRepository, RoleService roleService) {
		super();
		this.userRepository = userRepository;
		this.roleService = roleService;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CustomUser user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Error en el login");
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		
		return new User(username, user.getPassword(), user.getEnabled(), true, true, true, authorities);
		
	}
	
	@Transactional(readOnly = true)
	public CustomUser loadCustomUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Transactional()
	public boolean saveUser(CustomUser customUser) {
		
		CustomUser user = this.loadCustomUserByUsername(customUser.getUsername());
		if(user != null) {
			return false;
		}
		
		customUser.setPassword(new BCryptPasswordEncoder().encode(customUser.getPassword()));
		customUser.setEnabled(true);
		Set<Role> roles = new HashSet<Role>();
		roles.add(this.roleService.findUserRole());
		customUser.setRoles(roles);
		
		this.userRepository.save(customUser);
		
		return true;
	}
	
	public boolean deleteUser(CustomUser customUser) {
		this.userRepository.delete(customUser);
		
		return true;
	}

}
