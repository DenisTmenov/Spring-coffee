package com.denis.coffeebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denis.coffeebackend.dao.CategoryDAO;
import com.denis.coffeebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.denis.coffeebackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Ignore
	@Test
	public void testAddCategory() {

		category = new Category();

		category.setName("Coffee");
		category.setDescription("4444 coffee");
		category.setImageURL("coffeeLogo.jpg");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	}

	@Ignore
	@Test
	public void testGetCategoryById() {

		category = categoryDAO.getById(3);

		assertEquals("Successfully got a category from the table!", "Coffee", category.getName());

	}

	@Ignore
	@Test
	public void testUpdateCategory() {

		category = categoryDAO.getById(3);

		category.setName("Sweets");
		category.setDescription("Different kinds of delicious sweets.");
		category.setImageURL("Sweets_Logo.jpeg");

		assertEquals("Successfully updated a category in the table!", true, categoryDAO.update(category));

	}

	@Ignore
	@Test
	public void testDeleteCategory() {

		category = categoryDAO.getById(3);

		assertEquals("Successfully deleted a category in the table!", true, categoryDAO.delete(category));

	}

	@Ignore
	@Test
	public void testLoadAllCategories() {

		assertEquals("Successfully got the list of categories from the table!", 2, categoryDAO.loadAllCategories().size());

	}

	@Ignore
	@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();

		category.setName("Coffee");
		category.setDescription("4444 coffee");
		category.setImageURL("coffeeLogo.jpg");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Coffee5555");
		category.setDescription("5555 coffee");
		category.setImageURL("coffeeLogo5555.jpg");
		category.setActive(true);

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.getById(2);

		category.setName("Coffee");

		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));

		// delete the category
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));

		// fetching the list
		assertEquals("Successfully got the list of categories from the table!", 1, categoryDAO.loadAllCategories().size());

	}
}
