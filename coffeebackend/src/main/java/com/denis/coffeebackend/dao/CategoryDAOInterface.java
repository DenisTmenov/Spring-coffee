package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.entity.CategoryEntity;
import com.denis.coffeebackend.exception.CategoryException;

public interface CategoryDAOInterface {

	List<CategoryEntity> loadAllCategories() throws CategoryException;

	CategoryEntity getById(int id);
}