package com.traveloid.trippple.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

import com.traveloid.trippple.dao.UserDao;
import com.traveloid.trippple.entity.Campus;
import com.traveloid.trippple.entity.User;
import com.traveloid.trippple.util.PersistenceManager;

public class JpaUserDao implements UserDao{

	private EntityManager manager = null;
	
	public JpaUserDao()
	{
		this.manager = PersistenceManager.getFactory().createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll()
	{
		Query query = manager.createQuery("SELECT campus FROM Campus As campus");
		
		return (List<User>) query.getResultList();
	}
	
	@Override
	public User findById(Long id)
	{
		User result;
		
		try {
			result = manager.find(User.class, id);
		}
		catch (NoResultException e){
			result = null;
		}
		finally {
			manager.close();
		}
		return result;
	}
	
	@Override
	public User addUser(User user)
	{
		User result = null;
		
		manager.getTransaction().begin();
		try {
			manager.persist(user);
			manager.getTransaction().commit();
			result = user;
		}
		finally {
			if (manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
		}
		return result;
	}

	@Override
	public void updateUser(User user)
	{
		manager.getTransaction().begin();
		try{
			manager.merge(user);
			manager.getTransaction().commit();
		}
		finally {
			if (manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
		}
	}
	
	public void removeUser(User user)
	{
		manager.getTransaction().begin();
		try{
			manager.remove(user);
			manager.getTransaction().commit();
		}
		finally {
			if (manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
		}
	}
}
