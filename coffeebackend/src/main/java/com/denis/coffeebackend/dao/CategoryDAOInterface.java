package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.dto.Category;
import com.denis.coffeebackend.exception.CategoryException;

public interface CategoryDAOInterface {

	List<Category> loadAllCategories() throws CategoryException;

	Category getById(int id);

	boolean add(Category category);
}