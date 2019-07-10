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

	public void deleteCategory(Integer id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	public void updateCategory(String id) {
		// TODO Auto-generated method stub
		
	}

	

	public Category findCategoryById(String id) {
		Category category = categoryMapper.selectByPrimaryKey(1);
		return category;
	}

	public List findAllCategorys() {
		List<Category> list = categoryMapper.selectByExample(null);
		return list;
	}

	

}
