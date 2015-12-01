package com.traveloid.trippple.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.traveloid.trippple.dao.TripDao;
import com.traveloid.trippple.entity.Trip;
import com.traveloid.trippple.util.PersistenceManager;

public class JpaTripDao implements TripDao {
private EntityManager manager = null;
	
	public JpaTripDao() {
		this.manager = PersistenceManager.getFactory().createEntityManager();
	}

	@SuppressWarnings("unchecked") // masque les erreurs li�es au cast (ligne 25). De base, il faut v�rifier la bonne ex�cution d'un cast
	@Override
	public List<Trip> findAll() {
		Query query = manager.createQuery("SELECT trip FROM Trip as trip");

		return (List<Trip>) query.getResultList();
	}
	
	@Override
	public Trip findById(Long id) {
		Trip result;
		
		try {
			result = manager.find(Trip.class, id);
		} catch (NoResultException e){
			result = null;
		} finally {
			manager.close();
		}
		
		return result;	
	}
	
	@Override
	public Trip addTrip(Trip trip) { // Trip en retour : on pourra ex�cuter une m�thode sur la m�me ligne que l'ajout, ou v�rifier le bon ajout de l'entit� en v�rifiant que le retour n'est pas �gal � null
		Trip result = null;
		
		manager.getTransaction().begin();
		try {
			manager.persist(trip);
			manager.getTransaction().commit();
			result = trip; // Si on a pas r�ussi l'ajout, on met le trip pass� en param�tres dans result
		} finally {
			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
		
		return result;
	}
	
	@Override
	public void updateTrip(Trip trip) {
		manager.getTransaction().begin();
		try {
			manager.merge(trip);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
	}
	
	@Override
	public void removeTrip(Trip trip) {
		manager.getTransaction().begin();
		
		try {
			manager.remove(trip);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> findByCampus(String search) {
		Query query = manager.createQuery("SELECT trip FROM Trip as trip WHERE trip.origin.name LIKE :search OR trip.destination.name LIKE :search");
		query.setParameter("search", "%" + search + "%");

		return (List<Trip>) query.getResultList();
	}

}
