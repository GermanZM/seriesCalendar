package com.zdev.seriescalendar.episode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdev.seriescalendar.episode.repository.EpisodeRepository;

@Service
public class EpisodeService {

	public EpisodeRepository episodeRepository;
	
	@Autowired
	public EpisodeService(EpisodeRepository episodeRepository) {
		super();
		this.episodeRepository = episodeRepository;
	}
	
}
