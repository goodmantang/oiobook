package com.chinasofti.ssmdemo.ssm.dal.entity;

public class Category {
    @Override
	/*public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", parentCategoryId="
				+ parentCategoryId + "]";
	}*/
    public String toString() {
		return categoryName;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.id
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    private Integer categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.category_name
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    private String categoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.parent_category_id
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    private Integer parentCategoryId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.id
     *
     * @return the value of category.id
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.id
     *
     * @param categoryId the value for category.id
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.category_name
     *
     * @return the value of category.category_name
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.category_name
     *
     * @param categoryName the value for category.category_name
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.parent_category_id
     *
     * @return the value of category.parent_category_id
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.parent_category_id
     *
     * @param parentCategoryId the value for category.parent_category_id
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}