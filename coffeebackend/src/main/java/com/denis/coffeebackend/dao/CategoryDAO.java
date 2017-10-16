package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.dto.Category;
import com.denis.coffeebackend.exception.CategoryException;

public interface CategoryDAO {

	List<Category> loadAllCategories() throws CategoryException;

	Category getById(int id);

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);
}