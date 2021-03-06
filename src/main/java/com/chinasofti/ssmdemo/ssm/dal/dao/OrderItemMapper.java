package com.chinasofti.ssmdemo.ssm.dal.dao;

import com.chinasofti.ssmdemo.ssm.dal.entity.OrderItem;
import com.chinasofti.ssmdemo.ssm.dal.entity.OrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int countByExample(OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int deleteByExample(OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int deleteByPrimaryKey(Integer orderItemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int insert(OrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int insertSelective(OrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    List<OrderItem> selectByExample(OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    OrderItem selectByPrimaryKey(Integer orderItemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int updateByPrimaryKeySelective(OrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    int updateByPrimaryKey(OrderItem record);
}