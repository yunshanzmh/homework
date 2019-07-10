package com.yunshan.service;

import java.util.List;

import com.yunshan.pojo.Category;

public interface CategoryService {
	
	
	//	增加
	public void addCategory(Category category);

	// 删除
	public void deleteCategory(Category category);

	// 修改
	public void updateCategory(Category category);

	// 查询所有
	public List findAllCategorys();

	// 根据id查询
	public Category findCategoryById(Category category);
}
