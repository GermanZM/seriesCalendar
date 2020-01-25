package com.zdev.seriescalendar.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zdev.seriescalendar.film.dao.FilmRepository;

@Service
public class FilmService  {
	
	public FilmRepository filmRepository;
	
	@Autowired
	public FilmService(FilmRepository filmRepository) {
		super();
		this.filmRepository = filmRepository;
	}

}
