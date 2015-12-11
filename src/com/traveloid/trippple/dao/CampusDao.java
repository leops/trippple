package com.traveloid.trippple.dao;

import java.util.List;

import com.traveloid.trippple.entity.Campus;

public interface CampusDao {
	List<Campus> findAll();

	Campus findById(Long id);

	Campus addCampus(Campus campus);

	void updateCampus(Campus campus);

	void removeCampus(Campus campus);
}
