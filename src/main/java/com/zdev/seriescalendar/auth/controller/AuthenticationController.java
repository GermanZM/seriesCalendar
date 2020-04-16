package com.zdev.seriescalendar.auth.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zdev.seriescalendar.auth.config.JwtTokenUtil;
import com.zdev.seriescalendar.auth.model.CustomUser;
import com.zdev.seriescalendar.auth.model.JwtRequest;
import com.zdev.seriescalendar.auth.model.JwtResponse;
import com.zdev.seriescalendar.auth.model.Role;
import com.zdev.seriescalendar.auth.service.JwtUserService;
import com.zdev.seriescalendar.auth.service.RoleService;
import com.zdev.seriescalendar.error.model.CustomException;
import com.zdev.seriescalendar.error.model.ResponseError;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserService jwtUserService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = jwtUserService.loadUserByUsername(authenticationRequest.getUsername());
			final CustomUser customUser = jwtUserService.loadCustomUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token, customUser));
		} catch (CustomException e) {
			return ResponseEntity.ok(e.getResponseError());
		}
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new CustomException(new ResponseError(HttpStatus.BAD_REQUEST), "Usuario deshabilitado", e);
		} catch (BadCredentialsException e) {
			throw new CustomException(new ResponseError(HttpStatus.UNAUTHORIZED), "Credenciales incorrectas", e);
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> newUser(@RequestBody CustomUser newUser) throws Exception {
		CustomUser user = this.jwtUserService.loadCustomUserByUsername(newUser.getUsername());
		if(user != null) {
			return ResponseEntity.ok(new ResponseError(HttpStatus.BAD_REQUEST,"El usuario " + newUser.getUsername() + " ya existe en el sistema"));
		}
		
		newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
		newUser.setEnabled(true);
		Set<Role> roles = new HashSet<Role>();
		roles.add(this.roleService.findUserRole());
		newUser.setRoles(roles);
		
		this.jwtUserService.saveUser(newUser);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<?> authenticationLogout(@RequestBody CustomUser customUser) {
		//Pendiente consulta a base de datos para saber si el usuario está logueado o no
		if(customUser != null)
			return ResponseEntity.ok(HttpStatus.OK);
		
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
	
}
