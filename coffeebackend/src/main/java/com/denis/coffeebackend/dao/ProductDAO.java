package com.denis.coffeebackend.dao;

import java.util.List;

import com.denis.coffeebackend.dto.Product;

public interface ProductDAO {

	List<Product> loadAllProducts();

	Product getById(int id);

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	// bisiness methoda
	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLastestActiveProducts(int count);
	
	List<Product> listAllBrands();
}