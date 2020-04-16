package com.zdev.seriescalendar.serie.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zdev.seriescalendar.serie.model.Serie;

public interface SerieRepository extends CrudRepository<Serie, Integer> {
	
	public Iterable<Serie> findSerieByTitle(String title);

	@Query(value = "SELECT * FROM Serie S ORDER BY title", nativeQuery = true)
	public Iterable<Serie> findAllSeriesOrderByName();
}
