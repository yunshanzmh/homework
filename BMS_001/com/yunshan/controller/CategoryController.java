package com.yunshan.controller;

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
	@ResponseBody
	public PageInfo getBookWithJson(@RequestParam(value="pn",defaultValue = "1")Integer pn) {
		PageHelper.startPage(pn,5);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		
		return page;
	}
	
	//@RequestMapping("/findAll")
	public String findAll(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model) {
		PageHelper.startPage(pn,5);
		System.out.println(11111);
		List blist = categoryService.findAllCategorys();
		PageInfo page = new PageInfo(blist,5);
		model.addAttribute("pageInfo", page);
		
		return "list";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Category saveBook(Category category) {
		System.out.println(category);
		return null;
	}

}
