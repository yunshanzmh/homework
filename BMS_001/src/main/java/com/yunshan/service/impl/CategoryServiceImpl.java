package com.yunshan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunshan.dao.CategoryMapper;
import com.yunshan.pojo.Category;
import com.yunshan.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryMapper categoryMapper;
	
	public void addCategory(Category category) {
		categoryMapper.insert(category);
	}

	public void deleteCategory(Category category) {
		categoryMapper.deleteByPrimaryKey(category.getId());
	
	}

	public void updateCategory(Category category) {
		categoryMapper.updateByPrimaryKey(category);
		
	}

	

	public Category findCategoryById(Category category) {
		Category c = categoryMapper.selectByPrimaryKey(category.getId());
		return c;
	}

	public List findAllCategorys() {
		List<Category> list = categoryMapper.selectByExample(null);
		return list;
	}

	

}
