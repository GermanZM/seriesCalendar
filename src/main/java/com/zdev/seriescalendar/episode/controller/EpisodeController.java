package com.zdev.seriescalendar.episode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.zdev.seriescalendar.episode.service.EpisodeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EpisodeController {
	
	private EpisodeService episodeService;
	
	@Autowired
	public EpisodeController(EpisodeService episodeService) {
		this.episodeService = episodeService;
	}
	
//	@RequestMapping(path="/episode",method = RequestMethod.GET)
//	public @ResponseBody Iterable<Episode> getAllFilms() {
//		return this.episodeService.episodeRepository.findAll();
//	}
	
	

}
