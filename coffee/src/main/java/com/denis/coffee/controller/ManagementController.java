package com.denis.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.denis.coffeebackend.dao.CategoryDAO;
import com.denis.coffeebackend.dao.ProductDAO;
import com.denis.coffeebackend.dto.Category;
import com.denis.coffeebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product newProduct = new Product();

		newProduct.setSupplierId(1);
		newProduct.setActive(true);

		mv.addObject("product", newProduct);

		return mv;
	}

	@ModelAttribute("categories")
	public List<Category> getCategory() {

		return categoryDAO.loadAllCategories();
	}

	@ModelAttribute("brands")
	public List<Product> getBrands() {

		return productDAO.listAllBrands();
	}
}
