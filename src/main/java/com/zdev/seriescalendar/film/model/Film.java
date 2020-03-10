package com.zdev.seriescalendar.film.model;

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

@Entity
@Table(name = "film")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "film_id", unique = true, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@NotNull
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull
	@Column(name = "duration", nullable = true)
	private double duration;
	
	@Column(name = "publicationYear", nullable = true)
	private int publicationYear;
	
	@Column(name = "photo",nullable = true)
	private String photo;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	@JsonIgnore //Solve infinite loop (JSON Serialize) 
	private Set<FilmUserRelation> users;

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

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
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

	public Set<FilmUserRelation> getUsers() {
		return users;
	}

	public void setUsers(Set<FilmUserRelation> users) {
		this.users = users;
	}
	
	
	
}
