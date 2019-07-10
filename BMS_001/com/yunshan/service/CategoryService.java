package com.yunshan.service;

import java.util.List;

import com.yunshan.pojo.Category;

public interface CategoryService {
	
	
	//	增加
	public void addCategory(Category category);

	// 删除
	public void deleteCategory(String id);

	// 修改
	public void updateCategory(String id);

	// 查询所有
	public List findAllCategorys();

	// 根据id查询
	public Category findCategoryById(String id);
}
