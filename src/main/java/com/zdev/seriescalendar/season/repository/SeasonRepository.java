package com.zdev.seriescalendar.season.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zdev.seriescalendar.season.model.Season;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Integer>{

	
	
}
