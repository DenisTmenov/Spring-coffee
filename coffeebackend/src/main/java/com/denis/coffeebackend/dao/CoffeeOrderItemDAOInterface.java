package com.denis.coffeebackend.dao;

import com.denis.coffeebackend.entity.CoffeeOrderItemEntity;
import com.denis.coffeebackend.exception.EntityException;

public interface CoffeeOrderItemDAOInterface {

	void save(CoffeeOrderItemEntity bean) throws EntityException;

}
