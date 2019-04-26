package com.dev.smarthome.dao;

import java.util.List;

public interface IUserDao<T> {
	List<T> get(String email);

	List<T> getAll();

	void save(T t);

	void update(T t, String[] params);

	void delete(T t);
}
