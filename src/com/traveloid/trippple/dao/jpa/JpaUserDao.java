package com.traveloid.trippple.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.traveloid.trippple.dao.UserDao;
import com.traveloid.trippple.entity.User;
import com.traveloid.trippple.util.PersistenceManager;

public class JpaUserDao implements UserDao {

	private EntityManager manager = null;

	public JpaUserDao() {
		this.manager = PersistenceManager.getFactory().createEntityManager();
	}

	public void destroy() {
		if(this.manager.isOpen()) {
			this.manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Query query = manager.createQuery("SELECT user FROM User As user");

		return query.getResultList();
	}

	@Override
	public User findById(Long id) {
		User result;

		try {
			result = manager.find(User.class, id);
		} catch(NoResultException e) {
			result = null;
		}

		return result;
	}

	@Override
	public User addUser(User user) {
		User result = null;

		manager.getTransaction().begin();
		try {
			manager.persist(user);
			manager.getTransaction().commit();
			result = user;
		} finally {
			if(manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
		return result;
	}

	@Override
	public void updateUser(User user) {
		manager.getTransaction().begin();
		try {
			manager.merge(user);
			manager.getTransaction().commit();
		} finally {
			if(manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
	}

	@Override
	public void removeUser(User user) {
		manager.getTransaction().begin();
		try {
			manager.remove(user);
			manager.getTransaction().commit();
		} finally {
			if(manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
	}
}
