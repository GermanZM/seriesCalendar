package com.zdev.seriescalendar.serie.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zdev.seriescalendar.season.model.Season;

@Entity
@Table(name = "serie")
public class Serie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_serie_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@NotNull
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "publicationYear", nullable = true)
	private int publicationYear;
	
	@Column(name = "photo",nullable = true)
	private String photo;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnore
	private Set<SerieUserRelation> users;
	
	@OneToMany(mappedBy = "serie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnore
	private Set<Season> seasons;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<SerieUserRelation> getUsers() {
		return users;
	}

	public void setUsers(Set<SerieUserRelation> users) {
		this.users = users;
	}

	public Set<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(Set<Season> seasons) {
		this.seasons = seasons;
	}
	
	
}
