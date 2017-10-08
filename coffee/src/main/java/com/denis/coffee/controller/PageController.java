package com.denis.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.denis.coffeebackend.dao.CategoryDAOInterface;

@Controller
public class PageController {

	@Autowired
	private CategoryDAOInterface category;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// passing the list of category
		mv.addObject("category", category.loadAllCategories());

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

	@RequestMapping(value = { "/viewProduct" })
	public ModelAndView viewProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "View Product");
		mv.addObject("userClickViewProduct", true);
		return mv;
	}
}
