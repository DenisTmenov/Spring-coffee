package com.denis.coffeebackend.dao.mysql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denis.coffeebackend.dao.CategoryDAOInterface;
import com.denis.coffeebackend.dto.Category;
import com.denis.coffeebackend.exception.CategoryException;

@Repository("categoryDAO")
public class CategoryDAO implements CategoryDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		category.setId(1);
		category.setName("Coffee");
		category.setDescription("First coffee");
		category.setImageURL("coffeeLogo.jpg");
		category.setActive(true);

		categories.add(category);

		category = new Category();

		category.setId(2);
		category.setName("Snack");
		category.setDescription("First snack");
		category.setImageURL("snackLogo.jpg");
		category.setActive(true);

		categories.add(category);
	}

	@Override
	public List<Category> loadAllCategories() throws CategoryException {

		return categories;
	}

	@Override
	public Category getById(int id) {

		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			Session session = sessionFactory.getCurrentSession();

			session.persist(category);

			return true;
		} catch (Exception e) {
			new CategoryException("Error in CategoryDAO in add method.", e);
			return false;
		}

	}

}
