package com.zdev.seriescalendar.film.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zdev.seriescalendar.film.model.Film;
import com.zdev.seriescalendar.film.model.FilmUserKey;
import com.zdev.seriescalendar.film.model.FilmUserRelation;

@Repository
public interface FilmUserRepository extends CrudRepository<FilmUserRelation, FilmUserKey> {
	
	@Query("SELECT f FROM Film f left join FilmUserRelation fur on film_id = pk_film_Id "
			+ " WHERE pk_user_Id = ?1 ")
	public Iterable<Film> getAllFilmByUser(String userId);

}
