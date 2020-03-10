package com.zdev.seriescalendar.season.model;

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
import com.zdev.seriescalendar.episode.model.Episode;
import com.zdev.seriescalendar.serie.model.Serie;


@Entity
@Table(name = "Season")
public class Season implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_season_Id", unique = true, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "serie_id")
	private Serie serie;
	
	@OneToMany(mappedBy = "season", cascade = CascadeType.PERSIST)
	@JsonIgnore //Solve infinite loop (JSON Serialize) 
	private Set<Episode> episodes;
	
	public Season() {
		
	}

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

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}
	
	
	
	
	

}
