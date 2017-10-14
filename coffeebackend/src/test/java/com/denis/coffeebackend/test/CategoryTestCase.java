package com.denis.coffeebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denis.coffeebackend.dao.CategoryDAOInterface;
import com.denis.coffeebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAOInterface categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.denis.coffeebackend");
		context.refresh();
		categoryDAO = (CategoryDAOInterface) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {

		category = new Category();

		category.setName("Coffee");
		category.setDescription("4444 coffee");
		category.setImageURL("coffeeLogo.jpg");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

	}
}
