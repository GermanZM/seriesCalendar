package com.zdev.seriescalendar.serie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SerieUserKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "pk_serie_Id")
	private Integer serieId;
	
	@Column(name = "pk_user_Id")
	private Integer userId;
	
	public SerieUserKey() {
		
	}
	
	public SerieUserKey(Integer serieId, Integer userId) {
		this.serieId = serieId;
		this.userId = userId;
	}

	public Integer getSerieId() {
		return serieId;
	}

	public void setSerieId(Integer serieId) {
		this.serieId = serieId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
