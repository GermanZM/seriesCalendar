package com.zdev.seriescalendar.episode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EpisodeUserKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "pk_episode_Id")
	private Integer episodeId;
	
	@Column(name = "pk_user_Id")
	private Integer userId;
	
	public EpisodeUserKey() {
		
	}

	public EpisodeUserKey(Integer episodeId, Integer userId) {
		super();
		this.episodeId = episodeId;
		this.userId = userId;
	}

	public Integer getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Integer episodeId) {
		this.episodeId = episodeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
