package com.zdev.seriescalendar.film.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	
	@GetMapping("/films/images/{photoName:.+}") //Regular expression :.+ (photo.extension)
	public ResponseEntity<Resource> getPhoto(@PathVariable String photoName) {
		
		Path url = Paths.get("src/main/resources/images/films").resolve(photoName).toAbsolutePath();
		Resource img = null;
		try {
			img = new UrlResource(url.toUri());
		} catch (MalformedURLException e) {
			return new ResponseEntity<Resource>(img,HttpStatus.BAD_REQUEST);
		}
		
		if(!img.exists() && !img.isReadable())
			return new ResponseEntity<Resource>(img,HttpStatus.BAD_REQUEST);
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getFilename() + "\"");
		
		
		return new ResponseEntity<Resource>(img,header, HttpStatus.OK);
	}
	
}
