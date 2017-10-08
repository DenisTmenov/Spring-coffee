package com.denis.coffeebackend.dao.mysql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.denis.coffeebackend.dao.CategoryDAOInterface;
import com.denis.coffeebackend.entity.CategoryEntity;
import com.denis.coffeebackend.exception.CategoryException;

@Repository("category")
public class CategoryDAO implements CategoryDAOInterface {

	private static List<CategoryEntity> categories = new ArrayList<>();

	static {
		CategoryEntity category = new CategoryEntity();

		category.setId(1);
		category.setName("Coffee");
		category.setImageUrl("coffeeLogo.jpg");
		category.setActive(true);

		categories.add(category);

		category = new CategoryEntity();

		category.setId(2);
		category.setName("Snack");
		category.setImageUrl("snackLogo.jpg");
		category.setActive(true);

		categories.add(category);
	}

	@Override
	public List<CategoryEntity> loadAllCategories() throws CategoryException {

		return categories;
	}

	@Override
	public CategoryEntity getById(int id) {

		for (CategoryEntity category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
