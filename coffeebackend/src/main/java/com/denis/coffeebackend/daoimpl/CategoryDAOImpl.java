package com.denis.coffeebackend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denis.coffeebackend.dao.CategoryDAO;
import com.denis.coffeebackend.dto.Category;
import com.denis.coffeebackend.exception.CategoryException;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<Category> loadAllCategories() throws CategoryException {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}
	
	

	@Override
	public Category getById(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {
		try {
			Session session = sessionFactory.getCurrentSession();

			session.persist(category);

			return true;
		} catch (Exception e) {
			new CategoryException("Error in CategoryDAOImpl in add method.", e);
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {
			Session session = sessionFactory.getCurrentSession();

			session.update(category);

			return true;
		} catch (Exception e) {
			new CategoryException("Error in CategoryDAOImpl in update method.", e);
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);

		try {
			Session session = sessionFactory.getCurrentSession();

			session.update(category);

			return true;
		} catch (Exception e) {
			new CategoryException("Error in CategoryDAOImpl in update method.", e);
			return false;
		}
	}

}
