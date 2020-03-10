package com.zdev.seriescalendar.serie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdev.seriescalendar.serie.repository.SerieUserRepository;

@Service
public class SerieUserService {
	
	public SerieUserRepository serieUserRepository;
	
	@Autowired
	public SerieUserService(SerieUserRepository serieUserRepository) {
		super();
		this.serieUserRepository = serieUserRepository;
	}

}
