package com.chinasofti.ssmdemo.ssm.dal.domain;

import java.util.List;

import com.chinasofti.ssmdemo.ssm.dal.entity.OrderItem;
import com.chinasofti.ssmdemo.ssm.dal.entity.OrderListInfo;

public class OrderList {
private OrderListInfo orderListinfo;
private List<OrderItem> orderitems;
@Override
public String toString() {
	return "OrderList [orderListinfo=" + orderListinfo + ", orderitems=" + orderitems + "]";
}
public OrderListInfo getOrderListinfo() {
	return orderListinfo;
}
public void setOrderListinfo(OrderListInfo orderListinfo) {
	this.orderListinfo = orderListinfo;
}
public List<OrderItem> getOrderitems() {
	return orderitems;
}
public void setOrderitems(List<OrderItem> orderitems) {
	this.orderitems = orderitems;
}

}
