package com.denis.coffee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.denis.coffee.util.FileUploader;
import com.denis.coffee.validator.ProductValidator;
import com.denis.coffeebackend.dao.CategoryDAO;
import com.denis.coffeebackend.dao.ProductDAO;
import com.denis.coffeebackend.dto.Category;
import com.denis.coffeebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	private final static Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name = "success", required = false) String success) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Product Management");

		Product newProduct = new Product();

		newProduct.setSupplierId(1);
		newProduct.setActive(true);

		mv.addObject("product", newProduct);

		if (success != null) {
			if (success.equals("product")) {
				mv.addObject("message", "Product submitted successfully!");
			} else if (success.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}

		}

		return mv;
	}

	@RequestMapping("/{id}/product")
	public ModelAndView manageProductEdit(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product Management");
		mv.addObject("userClickManageProduct", true);

		mv.addObject("product", productDAO.getById(id));

		return mv;

	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String handleProductsSubmission(@Valid @ModelAttribute("product") Product modProduct, BindingResult results, Model model, HttpServletRequest request) {

		// validate errors

		new ProductValidator().validate(modProduct, results);

		// check errors
		if (results.hasErrors()) {

			model.addAttribute("title", "Product Management");
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("messageError", "Product validation has been failed!");

			return "page";
		}

		StringBuilder pathAndName = new StringBuilder();
		pathAndName.append(categoryDAO.getById(modProduct.getCategoryId()).getName()).append("/").append(modProduct.getBrand()).append("/");

		modProduct.setCode(modProduct.getCode().replaceFirst("PRD", pathAndName.toString() + "PRD"));

		logger.info(modProduct.toString());

		// create a new product record
		productDAO.add(modProduct);

		if (!modProduct.getFile().getOriginalFilename().equals("")) {
			FileUploader.uploadFile(request, modProduct.getFile(), modProduct.getCode());
		}

		return "redirect:/manage/product?success=product";
	}

	@ModelAttribute("categories")
	public List<Category> getCategory() {

		return categoryDAO.loadAllCategories();
	}

	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();
	}

}
