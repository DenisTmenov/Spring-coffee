package com.denis.coffeebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denis.coffeebackend.dao.ProductDAO;
import com.denis.coffeebackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.denis.coffeebackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Ignore
	@Test
	public void testCRUDProduct() {

		// add operation
		product = new Product();

		product.setName("Product 01");
		product.setBrand("Brand 01");
		product.setDescription("Description 01");
		product.setUnitPrice(1000);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(2);

		assertEquals("Successfully added a new product inside the table!", true, productDAO.add(product));

		product = new Product();

		product.setName("Product 02");
		product.setBrand("Brand 02");
		product.setDescription("Description 02");
		product.setUnitPrice(2000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);

		assertEquals("Successfully added a new product inside the table!", true, productDAO.add(product));

		// fetching and updating the category
		product = productDAO.getById(3);

		product.setName("New Product name");

		assertEquals("Successfully updated a single product in the table!", true, productDAO.update(product));

		// delete the category
		assertEquals("Successfully deleted a single product in the table!", true, productDAO.delete(product));

		// fetching the list
		assertEquals("Successfully got the list of categories from the table!", 4, productDAO.list().size());

	}

	@Test
	public void testListActiveProducts() {
		assertEquals("Successfully got the list of categories from the table!", 3, productDAO.listActiveProducts().size());
	}

	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Successfully got the list of categories from the table!", 1, productDAO.listActiveProductsByCategory(2).size());
	}

	@Test
	public void testGetLastestActiveProducts() {
		assertEquals("Successfully got the list of categories from the table!", 3, productDAO.getLastestActiveProducts(3).size());
	}

}
