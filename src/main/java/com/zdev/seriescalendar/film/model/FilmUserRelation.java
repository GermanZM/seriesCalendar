package com.zdev.seriescalendar.film.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.zdev.seriescalendar.auth.model.CustomUser;

@Entity
@Table(name = "FilmUserRelation")
public class FilmUserRelation implements Serializable  {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FilmUserKey id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@MapsId("pk_film_Id")
	@JoinColumn(name = "pk_film_Id")
	private Film film;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@MapsId("pk_user_Id")
	@JoinColumn(name = "pk_user_Id")
	private CustomUser user;
	
	@Column(name = "viewDate", nullable = false)
	private Date viewDate;

	public FilmUserKey getId() {
		return id;
	}

	public void setId(FilmUserKey id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	public Date getDate() {
		return viewDate;
	}

	public void setDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	

	
	
	

}
