package com.zdev.seriescalendar.season.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdev.seriescalendar.season.repository.SeasonRepository;

@Service
public class SeasonService {
	
	public SeasonRepository seasonRepository;
	
	@Autowired
	public SeasonService(SeasonRepository seasonRepository) {
		super();
		this.seasonRepository = seasonRepository;
	}

}
