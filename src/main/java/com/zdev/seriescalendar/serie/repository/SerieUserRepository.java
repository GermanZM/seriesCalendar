package com.zdev.seriescalendar.serie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zdev.seriescalendar.serie.model.SerieUserKey;
import com.zdev.seriescalendar.serie.model.SerieUserRelation;

@Repository
public interface SerieUserRepository extends CrudRepository<SerieUserRelation, SerieUserKey>{

	
}
