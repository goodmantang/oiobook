package com.chinasofti.ssmdemo.ssm.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.ssmdemo.ssm.dal.domain.OrderList;
import com.chinasofti.ssmdemo.ssm.dal.entity.Cart;
import com.chinasofti.ssmdemo.ssm.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService os;
	
	private static Logger logger = LoggerFactory.getLogger(BookController.class);

	@RequestMapping("add")
	@ResponseBody
	public Map<String,Object> add(int userId,int bookId,Integer count){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", os.addCart(userId, bookId, count)==1);
		return map;
	}
	
	@RequestMapping("queryCart")
	public String queryCart(int userId,Integer pageIdx,ModelMap modelMap){
		pageIdx= pageIdx==null?1:pageIdx;
		List<Cart> cartList=os.queryCart(userId,pageIdx);
		int pageCount = os.count(userId);
		modelMap.put("cart",cartList );
		modelMap.put("pageIdx",pageIdx);
		modelMap.put("pageCount",pageCount);	
		System.out.println("购物车数据："+cartList);
		return "myshoppingcart";
	}
	
	@RequestMapping("queryOrder")
	public String queryOrder(int userId,Integer pageIdx,ModelMap modelMap){
		pageIdx= pageIdx==null?1:pageIdx;
		List<OrderList> oList = os.queryOrderList(userId, pageIdx);
		int pageCount = os.countOrder(userId);
		modelMap.put("OrderList", oList);
		modelMap.put("pageIdx", pageIdx);
		modelMap.put("totalPage", pageCount);
		return "myorder";
	}
	
	@RequestMapping("pay")
	@ResponseBody
	public Map<String,Object> pay(int bookId,int userId,int addressId,int count,int payment,BigDecimal totalAmount){
		Map<String,Object> map = new HashMap<String,Object>();
		int result=os.payOne(bookId, userId, addressId, count, payment, totalAmount);
		if(result==-1){
			map.put("success", false);
			map.put("msg", "余额不足，请充值");
		}else if(result==1){
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("msg", "系统有误，请联系管理员");
		}
		return map;
	}
	
}
