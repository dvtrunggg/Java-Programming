/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.service;

/**
 *
 * @author trung
 */
import java.util.List;

public interface BaseStatusService<T, K> {
	List<T> getAll();

	T getById(K id);
}
