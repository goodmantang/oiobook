package com.chinasofti.ssmdemo.ssm.dal.dao;

import com.chinasofti.ssmdemo.ssm.dal.entity.Category;
import com.chinasofti.ssmdemo.ssm.dal.entity.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int countByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int deleteByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int insertSelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    List<Category> selectByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    Category selectByPrimaryKey(Integer categoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Wed Sep 13 11:25:51 CST 2017
     */
    int updateByPrimaryKey(Category record);
}