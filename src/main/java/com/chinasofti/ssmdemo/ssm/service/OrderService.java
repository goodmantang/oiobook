package com.chinasofti.ssmdemo.ssm.service;

import java.math.BigDecimal;
import java.util.List;

import com.chinasofti.ssmdemo.ssm.dal.domain.OrderList;
import com.chinasofti.ssmdemo.ssm.dal.entity.Cart;

public interface OrderService {

	int addCart(int userId, int bookId, Integer count);
	List<Cart> queryCart(int userId,Integer pageIdx);
	int count(int userId);
	
	int payOne(int bookId,int userId,int addressId,int count,int payment,BigDecimal totalAmount);
	
	List<OrderList> queryOrderList(int userId,Integer pageIdx);
	int countOrder(int userId);
}
