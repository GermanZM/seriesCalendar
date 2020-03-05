package com.zdev.seriescalendar.serie.dao;

import org.springframework.data.repository.CrudRepository;
import com.zdev.seriescalendar.serie.model.Serie;

public interface SerieRepository extends CrudRepository<Serie, Integer> {
	
	public Iterable<Serie> findSerieByTitle(String title);

}
