package com.zdev.seriescalendar.film.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.zdev.seriescalendar.auth.model.CustomUser;

@Entity
@Table(name = "FilmUserRelation")
public class FilmUserRelation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn
	@JoinColumn(name = "pk_film_Id")
	private Film film;
	
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn
	@JoinColumn(name = "pk_user_Id")
	private CustomUser user;
	
	@NotNull
	@Column(name = "date",nullable = false)
	private Date date;
	

}
