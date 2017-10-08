package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.entity.CategoryEntity;
import com.denis.coffeebackend.exception.CategoryException;

public interface CategoryDAOInterface {

	public List<CategoryEntity> loadAllCategories() throws CategoryException;
}