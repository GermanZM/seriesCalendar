package com.zdev.seriescalendar.auth.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zdev.seriescalendar.episode.model.EpisodeUserRelation;
import com.zdev.seriescalendar.film.model.FilmUserRelation;
import com.zdev.seriescalendar.serie.model.SerieUserRelation;

@Entity
@Table(name = "user")
public class CustomUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@NotNull
	@OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Profile profile;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name = "user_role", 
		joinColumns = { @JoinColumn(name = "pk_user_id", nullable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "pk_role_id", nullable = false) })
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnore
	private Set<FilmUserRelation> films;
	
	@OneToMany(mappedBy = "serie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnore
	private Set<SerieUserRelation> series;
	
	@OneToMany(mappedBy = "episode", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnore
	private Set<EpisodeUserRelation> episodes;

	public CustomUser() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<FilmUserRelation> getFilms() {
		return films;
	}

	public void setFilms(Set<FilmUserRelation> films) {
		this.films = films;
	}

	
	

}
