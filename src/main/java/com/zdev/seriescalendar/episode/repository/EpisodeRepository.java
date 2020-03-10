package com.zdev.seriescalendar.episode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zdev.seriescalendar.episode.model.Episode;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Integer> {

	
	
}
