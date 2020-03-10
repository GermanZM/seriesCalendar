package com.zdev.seriescalendar.film.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmUserKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "pk_film_Id")
	private Integer filmId;
	
	@Column(name = "pk_user_Id")
	private Integer userId;
	
	public FilmUserKey() {
		
	}
	
	public FilmUserKey(Integer filmId, Integer userId) {
		this.filmId = filmId;
		this.userId = userId;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}
