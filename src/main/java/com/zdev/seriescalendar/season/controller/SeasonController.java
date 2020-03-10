package com.zdev.seriescalendar.season.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.zdev.seriescalendar.season.service.SeasonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeasonController {
	
	private SeasonService seasonService;
	
	@Autowired
	public SeasonController(SeasonService seasonService) {
		super();
		this.seasonService = seasonService;
	}

}
