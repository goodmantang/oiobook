package com.chinasofti.ssmdemo.ssm.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.ssmdemo.ssm.dal.dao.AddressMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.BalanceRecordMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.BookMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.CartMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.OrderItemMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.OrderListInfoMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.UserInfoMapper;
import com.chinasofti.ssmdemo.ssm.dal.domain.OrderList;
import com.chinasofti.ssmdemo.ssm.dal.entity.Address;
import com.chinasofti.ssmdemo.ssm.dal.entity.BalanceRecord;
import com.chinasofti.ssmdemo.ssm.dal.entity.Book;
import com.chinasofti.ssmdemo.ssm.dal.entity.Cart;
import com.chinasofti.ssmdemo.ssm.dal.entity.CartExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.OrderItem;
import com.chinasofti.ssmdemo.ssm.dal.entity.OrderItemExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.OrderListInfo;
import com.chinasofti.ssmdemo.ssm.dal.entity.OrderListInfoExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfo;
import com.chinasofti.ssmdemo.ssm.service.OrderService;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private OrderListInfoMapper orderListInfoMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private BalanceRecordMapper balanceRecordMapper;

	// 添加购物车
	@Override
	public int addCart(int userId, int bookId, Integer count) {
		CartExample ce = new CartExample();
		ce.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId);
		List<Cart> cartList = cartMapper.selectByExample(ce);
		Book b = bookMapper.selectByPrimaryKey(bookId);
		// 如果购物车有数据，则数量加1，没有的话就添加到购物车
		if (cartList.size() != 0) {
			Cart c = cartList.get(0);
			c.setCount(c.getCount() + 1);
			c.setTotalAmount(c.getTotalAmount().add(b.getPrice()));
			return cartMapper.updateByPrimaryKeySelective(c);
		}
		BigDecimal totalAmount = null;
		if (count == null) {
			count = 1;
			totalAmount = b.getPrice();
		} else {
			totalAmount = b.getPrice().multiply(new BigDecimal(count));
		}
		Cart c = new Cart();
		c.setBookName(b.getName());
		c.setBookId(bookId);
		c.setUserId(userId);
		c.setCount(count);
		c.setTotalAmount(totalAmount);
		return cartMapper.insertSelective(c);
	}

	// 查询购物车
	@Override
	public List<Cart> queryCart(int userId, Integer pageIdx) {
		pageIdx = pageIdx == null ? 1 : pageIdx;
		CartExample ce = new CartExample();
		ce.setPageIdx((pageIdx - 1) * 9);
		ce.setOrderByClause("id desc");
		ce.createCriteria().andUserIdEqualTo(userId);
		return cartMapper.selectByExample(ce);
	}

	// 数数
	@Override
	public int count(int userId) {
		CartExample ce = new CartExample();
		ce.createCriteria().andUserIdEqualTo(userId);
		int totalCount = cartMapper.countByExample(ce);
		int pageCount = totalCount % 9 == 0 ? totalCount / 9 : totalCount / 9 + 1;
		return pageCount;
	}

	// 直接从商品详情的地方直接付款，就一个产品，插入了订单表，订单详情表，用户收支表，如果是余额还改了用户余额
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int payOne(int bookId, int userId, int addressId,int count, int payment, BigDecimal totalAmount) {
		if (payment == 0) {
			UserInfo ui = userInfoMapper.selectByPrimaryKey(userId);
			if(ui.getBalance().compareTo(totalAmount)<0){
				return -1;
			}
			ui.setBalance(ui.getBalance().subtract(totalAmount));
			userInfoMapper.updateByPrimaryKeySelective(ui);
		}
		
		
		OrderListInfo oli = new OrderListInfo();
		oli.setUserId(userId);
		UserInfo u = userInfoMapper.selectByPrimaryKey(userId);
		oli.setUserName(u.getUserName());
		String orderId = System.nanoTime() + "";
		oli.setOrderId(orderId);
		Address address = addressMapper.selectByPrimaryKey(addressId);
		oli.setAddressName(address.getAddress());
		oli.setAddressId(addressId);
		oli.setCreateTime(new Date());
		oli.setTotalAmount(totalAmount);

		orderListInfoMapper.insertSelective(oli);

		OrderItem oi = new OrderItem();
		Book b = bookMapper.selectByPrimaryKey(bookId);
		b.setCount(b.getCount()-count);
		bookMapper.updateByPrimaryKeySelective(b);
		
		oi.setBookName(b.getName());
		oi.setBookImg(b.getImgUrl());
		oi.setBookId(bookId);
		oi.setEachPrice(b.getPrice());
		oi.setOrderId(orderId);
		oi.setCount(count);
		orderItemMapper.insertSelective(oi);

		BalanceRecord br = new BalanceRecord();
		br.setOperation(1);
		br.setAmount(totalAmount);
		br.setOrderId(orderId);
		br.setUserId(userId);
		br.setOperateTime(new Date());
		return balanceRecordMapper.insertSelective(br);

		
	}

	@Override
	public List<OrderList> queryOrderList(int userId, Integer pageIdx) {
		List<OrderList> olList = new ArrayList<>();
		pageIdx = pageIdx == null ? 1 : pageIdx;
		OrderListInfoExample olie = new OrderListInfoExample();
		olie.setPageIdx(pageIdx);
		olie.setOrderByClause("id desc");
		olie.createCriteria().andUserIdEqualTo(userId);
		List<OrderListInfo> oliList = orderListInfoMapper.selectByExample(olie);
		for (OrderListInfo oli : oliList) {
			OrderItemExample oie = new OrderItemExample();
			oie.createCriteria().andOrderIdEqualTo(oli.getOrderId());
			List<OrderItem> oiList = orderItemMapper.selectByExample(oie);
			OrderList oList = new OrderList();
			oList.setOrderListinfo(oli);
			oList.setOrderitems(oiList);
			olList.add(oList);
		}
		return olList;
	}

	@Override
	public int countOrder(int userId) {
		OrderListInfoExample olie = new OrderListInfoExample();
		olie.createCriteria().andUserIdEqualTo(userId);
		int totalCount = orderListInfoMapper.countByExample(olie);
		int pageCount = totalCount % 9 == 0 ? totalCount / 9 : totalCount / 9 + 1;
		return pageCount;
	}

}
