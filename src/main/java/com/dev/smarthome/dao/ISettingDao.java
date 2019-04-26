package com.dev.smarthome.dao;

import java.util.List;

public interface ISettingDao<T> {
	List<T> getAll();
	
	void save(T t);
	
	void update(T t);
	
	void delete(String id);
}
