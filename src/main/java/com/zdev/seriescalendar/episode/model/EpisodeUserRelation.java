package com.zdev.seriescalendar.episode.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.zdev.seriescalendar.auth.model.CustomUser;

@Entity
@Table(name = "EpisodeUserRelation")
public class EpisodeUserRelation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EpisodeUserKey id;
	
	@ManyToOne
	@MapsId("pk_episode_Id")
	@JoinColumn(name = "pk_episode_Id")
	private Episode episode;
	
	@ManyToOne
	@MapsId("pk_user_Id")
	@JoinColumn(name = "pk_user_Id")
	private CustomUser user;
	
	@Column(name = "viewDate", nullable = false)
	private Date viewDate;

	public EpisodeUserKey getId() {
		return id;
	}

	public void setId(EpisodeUserKey id) {
		this.id = id;
	}

	public Episode getEpisode() {
		return episode;
	}

	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	
}
