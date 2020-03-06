package com.zdev.seriescalendar.film.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.zdev.seriescalendar.auth.model.CustomUser;

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
	@Column(name = "duration", nullable = false)
	private double duration;
	
	@Column(name = "publicationYear", nullable = true)
	private int publicationYear;
	
	@Column(name = "photo",nullable = true)
	private String photo;
	
	@ManyToMany(mappedBy = "films")
	private Set<CustomUser> users;

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

	public Set<CustomUser> getUsers() {
		return users;
	}

	public void setUsers(Set<CustomUser> users) {
		this.users = users;
	}
	
	
	
}
