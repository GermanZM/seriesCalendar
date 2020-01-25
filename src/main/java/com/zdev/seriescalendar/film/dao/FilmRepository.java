package com.zdev.seriescalendar.film.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zdev.seriescalendar.film.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

	public Film findFilmByTitle(String title);
	
}
