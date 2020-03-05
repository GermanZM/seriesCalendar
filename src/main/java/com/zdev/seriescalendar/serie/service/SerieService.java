package com.zdev.seriescalendar.serie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdev.seriescalendar.serie.dao.SerieRepository;

@Service
public class SerieService {
	
	public SerieRepository serieRepository;
	
	@Autowired
	public SerieService(SerieRepository serieRepository) {
		super();
		this.serieRepository = serieRepository;
	}

}
