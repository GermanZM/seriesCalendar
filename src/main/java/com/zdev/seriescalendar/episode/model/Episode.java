package com.zdev.seriescalendar.episode.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "season_id")
	private Season season;
	
	@OneToMany(mappedBy = "episode", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Set<EpisodeUserRelation> users;

}
