package com.zdev.seriescalendar.serie.repository;

import org.springframework.data.repository.CrudRepository;
import com.zdev.seriescalendar.serie.model.Serie;

public interface SerieRepository extends CrudRepository<Serie, Integer> {
	
	public Iterable<Serie> findSerieByTitle(String title);

}
