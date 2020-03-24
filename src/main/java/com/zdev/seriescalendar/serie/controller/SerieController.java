package com.zdev.seriescalendar.serie.controller;

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

import com.zdev.seriescalendar.media.MediaResource;
import com.zdev.seriescalendar.serie.model.Serie;
import com.zdev.seriescalendar.serie.service.SerieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SerieController {

	private SerieService serieService;
	
	@Autowired
	public SerieController(SerieService serieService) {
		super();
		this.serieService = serieService;
	}
	
	@RequestMapping(path="/series",method = RequestMethod.GET)
	public @ResponseBody Iterable<Serie> getAllUsers() {
		return this.serieService.serieRepository.findAll();
	}
	
	@GetMapping("/server/images/series/{photoName:.+}") //Regular expression :.+ (photo.extension)
	public ResponseEntity<Resource> getSeriePhoto(@PathVariable String photoName) {
		return MediaResource.getPhoto(photoName,"src/main/resources/images/series");
	}
	
	
}
