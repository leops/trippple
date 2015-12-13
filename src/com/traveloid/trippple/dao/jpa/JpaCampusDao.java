package com.traveloid.trippple.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.traveloid.trippple.dao.CampusDao;
import com.traveloid.trippple.entity.Campus;
import com.traveloid.trippple.util.PersistenceManager;

public class JpaCampusDao implements CampusDao {

	private EntityManager manager = null;

	public JpaCampusDao() {
		this.manager = PersistenceManager.getFactory().createEntityManager();
	}

	public void destroy() {
		if(this.manager.isOpen()) {
			this.manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Campus> findAll()
	{
		Query query = manager.createQuery("SELECT campus FROM Campus As campus");

		return query.getResultList();
	}

	@Override
	public Campus findById(Long id)
	{
		Campus result;

		try {
			result = manager.find(Campus.class, id);
		} catch(NoResultException e) {
			result = null;
		}

		return result;
	}

	@Override
	public Campus addCampus(Campus campus)
	{
		Campus result = null;

		manager.getTransaction().begin();
		try {
			manager.persist(campus);
			manager.getTransaction().commit();
			result = campus;
		} finally {
			if(manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
		}
		return result;
	}

	@Override
	public void updateCampus(Campus campus)
	{
		manager.getTransaction().begin();
		try {
			manager.merge(campus);
			manager.getTransaction().commit();
		} finally {
			if(manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
		}
	}

	@Override
	public void removeCampus(Campus campus)
	{
		manager.getTransaction().begin();
		try {
			manager.remove(campus);
			manager.getTransaction().commit();
		} finally {
			if(manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
		}
	}
}
