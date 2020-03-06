package com.zdev.seriescalendar.serie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "serie")
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serie_id", unique = true, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@NotNull
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "publicationYear", nullable = true)
	private int publicationYear;
	
	@Column(name = "photo",nullable = true)
	private String photo;
	
}
