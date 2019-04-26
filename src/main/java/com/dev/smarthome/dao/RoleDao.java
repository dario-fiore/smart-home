package com.dev.smarthome.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dev.smarthome.entity.Role;

public class RoleDao implements IRoleDao<Role> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartHomePersistanceUnit");

	public RoleDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieve roles from datbase
	 */
	public List<Role> getAll() {
		EntityManager entityManager = factory.createEntityManager();

		List<Role> roles = null;

		Query query = entityManager.createQuery("SELECT e FROM Role e");

		roles = query.getResultList();

		return roles;
	}


}
