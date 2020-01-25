package com.zdev.seriescalendar.auth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zdev.seriescalendar.auth.model.CustomUser;

/**
 * Capa encargada de administrar el almacenamiento y recuperación de los datos.
 * @author German
 *
 */
@Repository
public interface UserRepository extends CrudRepository<CustomUser, Integer> {
	
	//@Query("SELECT * FROM USER U WHERE U.USERNAME = ?1")
	public CustomUser findByUsername(String username);

}

