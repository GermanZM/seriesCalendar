package com.zdev.seriescalendar.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zdev.seriescalendar.film.model.Film;
import com.zdev.seriescalendar.film.service.FilmService;
import com.zdev.seriescalendar.film.service.FilmUserService;
import com.zdev.seriescalendar.media.MediaResource;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController {
	
	private FilmService filmService;
	private FilmUserService filmUserService;
	
	@Autowired
	public FilmController(FilmService filmService, FilmUserService filmUserService) {
		super();
		this.filmService = filmService;
		this.filmUserService = filmUserService;
	}
	
	@RequestMapping(path="/films",method = RequestMethod.GET)
	public @ResponseBody Iterable<Film> getAllFilms() {
		return this.filmService.filmRepository.findAllFilmsOrderByName();
	}
	
	@RequestMapping(path="/filmsUser",method = RequestMethod.GET)
	public @ResponseBody Iterable<Film> getAllUserFilm(String userId) {
		return this.filmUserService.filmUserRepository.getAllFilmByUser(userId);
	}
	
	@GetMapping("/server/images/films/{photoName:.+}") //Regular expression :.+ (photo.extension)
	public ResponseEntity<Resource> getFilmPhoto(@PathVariable String photoName) {
		return MediaResource.getPhoto(photoName,"src/main/resources/images/films");
	}
	
}
