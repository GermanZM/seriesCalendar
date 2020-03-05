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
		return this.filmService.filmRepository.findAll();
	}
	
	@GetMapping("/server/images/films/{photoName:.+}") //Regular expression :.+ (photo.extension)
	public ResponseEntity<Resource> getServerPhoto(@PathVariable String photoName) {
		
		Path url = Paths.get("src/main/resources/images/films").resolve(photoName).toAbsolutePath();
		Resource img = null;
		HttpHeaders header = null;
		try {
			img = new UrlResource(url.toUri());
			
			if(!img.exists() && !img.isReadable()) {
				url = Paths.get("src/main/resources/images/").resolve("default.png").toAbsolutePath();
				img = new UrlResource(url.toUri());
				header = new HttpHeaders();
				header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getFilename() + "\"");
				return new ResponseEntity<Resource>(img,header,HttpStatus.OK);
			}
			
			header = new HttpHeaders();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getFilename() + "\"");

		} catch (MalformedURLException e) {
			return new ResponseEntity<Resource>(img,header,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Resource>(img,header, HttpStatus.OK);
	}
	
	
}
