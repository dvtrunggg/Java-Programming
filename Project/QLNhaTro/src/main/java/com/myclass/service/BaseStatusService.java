package com.myclass.service;

import java.util.List;

public interface BaseStatusService<T, K> {
	List<T> getAll();

	T getById(K id);
}
