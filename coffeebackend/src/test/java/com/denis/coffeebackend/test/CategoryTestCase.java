package com.denis.coffeebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denis.coffeebackend.dao.CategoryDAOInterface;
import com.denis.coffeebackend.entity.CategoryEntity;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAOInterface categoryDAO;

	private CategoryEntity category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.denis.coffeebackend");
		context.refresh();
		categoryDAO = (CategoryDAOInterface) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {

		category = new CategoryEntity();
		category.setId(3);
		category.setName("Coffee");
		category.setDescription("3333 coffee");
		category.setImageUrl("coffeeLogo.jpg");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

	}
}
