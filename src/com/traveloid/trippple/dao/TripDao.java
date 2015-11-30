package com.traveloid.trippple.dao;

import java.util.List;

import com.traveloid.trippple.entity.Trip;

public interface TripDao {
	List<Trip> findAll();
	Trip findById(Long id);
	Trip addTrip(Trip trip);
	void updateTrip(Trip trip);
	void removeTrip(Trip trip);
}
