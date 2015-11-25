package com.traveloid.trippple.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.traveloid.trippple.dao.TripDao;
import com.traveloid.trippple.entity.Trip;
import com.traveloid.trippple.util.PersistenceManager;

public class JpaTripDao implements TripDao {
private EntityManager manager = null;
	
	public JpaTripDao() {
		this.manager = PersistenceManager.getFactory().createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> findAll() {
		Query query = manager.createQuery("SELECT trip FROM Trip as trip");

		return (List<Trip>) query.getResultList();
	}

}
