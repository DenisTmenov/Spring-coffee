package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.entity.ConfigurationEntity;
import com.denis.coffeebackend.exception.EntityException;

public interface ConfigurationDAOInterface {

	public List<ConfigurationEntity> getConfigurationDataFromDb() throws EntityException;

}
