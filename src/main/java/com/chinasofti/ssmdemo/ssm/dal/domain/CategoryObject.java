package com.chinasofti.ssmdemo.ssm.dal.domain;

import java.util.List;

import com.chinasofti.ssmdemo.ssm.dal.entity.Category;

public class CategoryObject {
private Category category;
private List<Category> categoryList;
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public List<Category> getCategoryList() {
	return categoryList;
}
public void setCategoryList(List<Category> categoryList) {
	this.categoryList = categoryList;
}
@Override
public String toString() {
	return "CategoryObject [category=" + category + ", categoryList=" + categoryList + "]";
}

}
