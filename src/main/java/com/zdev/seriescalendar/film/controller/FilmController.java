package com.zdev.seriescalendar.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zdev.seriescalendar.film.model.Film;
import com.zdev.seriescalendar.film.service.FilmService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController {
	
	private FilmService filmService;
	
	@Autowired
	public FilmController(FilmService filmService) {
		super();
		this.filmService = filmService;
	}
	
	@RequestMapping(path="/films",method = RequestMethod.GET)
	public @ResponseBody Iterable<Film> getAllUsers() {
		return filmService.filmRepository.findAll();
	}
	
	@GetMapping(path="/films/uploads")
	public @ResponseBody String getPicture() {
		return "";
	}
	
}
