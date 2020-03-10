package com.zdev.seriescalendar.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdev.seriescalendar.film.repository.FilmUserRepository;

@Service
public class FilmUserService {
	
	public FilmUserRepository filmUserRepository;
	
	@Autowired
	public FilmUserService(FilmUserRepository filmUserRepository) {
		super();
		this.filmUserRepository = filmUserRepository;
	}

}
