package com.yunshan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunshan.pojo.Category;
import com.yunshan.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	

	@RequestMapping("/findAll")
	public String findAll(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model) {
		PageHelper.startPage(pn,5);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	
	@RequestMapping("/add")
	public String addBook(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model,Category category) {
		PageHelper.startPage(pn,5);
		categoryService.addCategory(category);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	@RequestMapping("/find")
	public String findById(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model,Category category) {
		PageHelper.startPage(pn,5);
		Category categoryById = categoryService.findCategoryById(category);
		List blist = new ArrayList();
		blist.add(categoryById);
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model,Category category) {
		PageHelper.startPage(pn,5);
		categoryService.deleteCategory(category);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
	
	@RequestMapping("/update")
	public String updateBook(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model,Category category) {
		PageHelper.startPage(pn,5);
		categoryService.updateCategory(category);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("pageInfo", page);
		return "list";
	}

}
