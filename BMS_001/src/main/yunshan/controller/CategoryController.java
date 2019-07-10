package com.yunshan.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yunshan.pojo.Category;
import com.yunshan.service.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/findAll")
	public String findAll(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model) {
		PageHelper.startPage(pn,5);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("cateInfo", blist);
		return "list";
	}
	
	@RequestMapping("/save")
	public String saveBook(String name,String description,Model model) {
		Category category = new Category();
		category.setName(name);
		category.setDescription(description);
		categoryService.addCategory(category);
		System.out.println(name);
		List blist = categoryService.findAllCategorys();
		model.addAttribute("cateInfo", blist);
		return "list";
	}

	@RequestMapping("/delete")
	public String deleteBook(Integer id,Model model) {
		Category category = new Category();
		System.out.println(1111);
		categoryService.deleteCategory(category.getId());
		System.out.println(category.getId());
		List blist = categoryService.findAllCategorys();
		model.addAttribute("cateInfo", blist);
		return "list";
	}

}
