package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.entity.CoffeeTypeEntity;
import com.denis.coffeebackend.exception.EntityException;

public interface CoffeeTypeDAOInterface {

	void save(CoffeeTypeEntity bean) throws EntityException;

	void update(CoffeeTypeEntity bean) throws EntityException;

	void remove(Integer idUser) throws EntityException;

	public List<CoffeeTypeEntity> loadAllCoffeeType() throws EntityException;

}
