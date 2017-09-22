package com.chinasofti.ssmdemo.ssm.dal.entity;

import java.math.BigDecimal;

public class OrderItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private Integer orderItemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.order_id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.book_id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private Integer bookId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.book_name
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private String bookName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.book_img
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private String bookImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.count
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.each_price
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private BigDecimal eachPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.status
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_item.return_reason
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    private String returnReason;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.id
     *
     * @return the value of order_item.id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public Integer getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.id
     *
     * @param orderItemId the value for order_item.id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.order_id
     *
     * @return the value of order_item.order_id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.order_id
     *
     * @param orderId the value for order_item.order_id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.book_id
     *
     * @return the value of order_item.book_id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.book_id
     *
     * @param bookId the value for order_item.book_id
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.book_name
     *
     * @return the value of order_item.book_name
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.book_name
     *
     * @param bookName the value for order_item.book_name
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.book_img
     *
     * @return the value of order_item.book_img
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public String getBookImg() {
        return bookImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.book_img
     *
     * @param bookImg the value for order_item.book_img
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setBookImg(String bookImg) {
        this.bookImg = bookImg == null ? null : bookImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.count
     *
     * @return the value of order_item.count
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.count
     *
     * @param count the value for order_item.count
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.each_price
     *
     * @return the value of order_item.each_price
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public BigDecimal getEachPrice() {
        return eachPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.each_price
     *
     * @param eachPrice the value for order_item.each_price
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setEachPrice(BigDecimal eachPrice) {
        this.eachPrice = eachPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.status
     *
     * @return the value of order_item.status
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.status
     *
     * @param status the value for order_item.status
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_item.return_reason
     *
     * @return the value of order_item.return_reason
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public String getReturnReason() {
        return returnReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_item.return_reason
     *
     * @param returnReason the value for order_item.return_reason
     *
     * @mbggenerated Wed Sep 20 19:48:18 CST 2017
     */
    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }
}