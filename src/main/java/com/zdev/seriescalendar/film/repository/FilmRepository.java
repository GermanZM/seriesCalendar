package com.zdev.seriescalendar.film.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zdev.seriescalendar.film.model.Film;

/**
 * Podemos usar anotación @Query y CristeriaBuilder
 * @author german.zurita
 *
 */
@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

	public Iterable<Film> findFilmByTitle(String title);
	
	
	
	
	
}
