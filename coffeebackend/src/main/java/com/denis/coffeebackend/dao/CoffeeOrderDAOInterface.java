package com.denis.coffeebackend.dao;

import com.denis.coffeebackend.entity.CoffeeOrderEntity;
import com.denis.coffeebackend.exception.EntityException;

public interface CoffeeOrderDAOInterface {

	void save(CoffeeOrderEntity bean) throws EntityException;

	String saveAndReturnDate(CoffeeOrderEntity bean) throws EntityException;

	Integer getIdOrderByDate(String dateOrder) throws EntityException;

}
