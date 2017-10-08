package com.denis.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.denis.coffeebackend.dao.CategoryDAOInterface;
import com.denis.coffeebackend.entity.CategoryEntity;

@Controller
public class PageController {

	@Autowired
	private CategoryDAOInterface categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// passing the list of category
		mv.addObject("category", categoryDAO.loadAllCategories());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contacts" })
	public ModelAndView contacts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contacts");
		mv.addObject("userClickContacts", true);
		return mv;
	}

	@RequestMapping(value = { "/services" })
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Services");
		mv.addObject("userClickServices", true);
		return mv;
	}

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Product");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.loadAllCategories());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		CategoryEntity category = null;

		category = categoryDAO.getById(id);
		mv.addObject("title", category.getName());

		// passing the single category object
		mv.addObject("title", category.getName());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}
}
