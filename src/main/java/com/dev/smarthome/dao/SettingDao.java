package com.dev.smarthome.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dev.smarthome.entity.Setting;

public class SettingDao implements ISettingDao<Setting> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartHomePersistanceUnit");

	public SettingDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieve settings from datbase
	 */
	public List<Setting> getAll() {
		EntityManager entityManager = factory.createEntityManager();
		List<Setting> settings = null;
		Query query = entityManager.createQuery("SELECT e FROM Setting e");
		settings = query.getResultList();
		return settings;
	}

	public void save(Setting setting) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(setting);
		entityManager.getTransaction().commit();
	}

	public void update(Setting setting) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(setting);
		entityManager.getTransaction().commit();
	}

	public void delete(String id) {
		EntityManager entityManager = factory.createEntityManager();
		Setting setting = entityManager.find(Setting.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(setting);
		entityManager.getTransaction().commit();
	}

}
