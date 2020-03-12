package com.zdev.seriescalendar.episode.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zdev.seriescalendar.season.model.Season;

@Entity
@Table(name = "Episode")
public class Episode implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_season_Id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "season_id")
	private Season season;
	
	@OneToMany(mappedBy = "episode", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnore
	private Set<EpisodeUserRelation> users;
	
	@Column(name = "publicationDay", nullable = false)
	private Date publicationDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Set<EpisodeUserRelation> getUsers() {
		return users;
	}

	public void setUsers(Set<EpisodeUserRelation> users) {
		this.users = users;
	}

	public Date getPublicationDay() {
		return publicationDay;
	}

	public void setPublicationDay(Date publicationDay) {
		this.publicationDay = publicationDay;
	}
	

}
