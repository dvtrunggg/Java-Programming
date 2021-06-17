package com.myclass.service;

import java.util.List;

public interface BaseService<T, K> {
	List<T> getAll();

	T getById(K id);

	int insert(T dto);

	int update(T dto);

	int delete(K id);
}