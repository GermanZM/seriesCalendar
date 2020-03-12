package com.zdev.seriescalendar.serie.model;

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
@Table(name = "SerieUserRelation")
public class SerieUserRelation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SerieUserKey id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@MapsId("pk_serie_Id")
	@JoinColumn(name = "pk_serie_Id")
	private Serie serie;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@MapsId("pk_user_Id")
	@JoinColumn(name = "pk_user_Id")
	private CustomUser user;
	
	@Column(name = "followDate", nullable = false)
	private Date followDate;
	
	@Column(name = "isFavourite", nullable = true)
	private boolean isFavourite = false;
	
	@Column(name = "isWatch", nullable = true)
	private boolean isWatch = false;

	public SerieUserKey getId() {
		return id;
	}

	public void setId(SerieUserKey id) {
		this.id = id;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	public Date getFollowDate() {
		return followDate;
	}

	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	public boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public boolean getIsWatch() {
		return isWatch;
	}

	public void setIsWatch(boolean isWatch) {
		this.isWatch = isWatch;
	}
	
}
