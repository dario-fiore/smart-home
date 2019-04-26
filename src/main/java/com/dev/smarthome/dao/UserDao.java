package com.dev.smarthome.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dev.smarthome.entity.User;

public class UserDao implements IUserDao<User> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartHomePersistanceUnit");

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieve user from datbase
	 */
	public List<User> get(String email) {
		EntityManager entityManager = factory.createEntityManager();

		List<User> user = null;

		Query query = entityManager.createQuery("SELECT e FROM User e where e.email = :username")
				.setParameter("username", email);

		user = query.getResultList();

		return user;
	}

	public List<User> getAll() {
		return null;
	}

	public void save(User user) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	public void update(User t, String[] params) {
	}

	public void delete(User user) {
	}

}
