package com.chinasofti.ssmdemo.ssm.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.ssmdemo.ssm.dal.dao.AddressMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.BalanceRecordMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.BankcardMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.UserInfoMapper;
import com.chinasofti.ssmdemo.ssm.dal.entity.Address;
import com.chinasofti.ssmdemo.ssm.dal.entity.AddressExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.BalanceRecord;
import com.chinasofti.ssmdemo.ssm.dal.entity.BalanceRecordExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.Bankcard;
import com.chinasofti.ssmdemo.ssm.dal.entity.BankcardExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfo;
import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfoExample;
import com.chinasofti.ssmdemo.ssm.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private BalanceRecordMapper  balanceRecordMapper;
	
	@Autowired
	private BankcardMapper bankcardMapper;
	@Override
	public int add(UserInfo u) {

		return userInfoMapper.insertSelective(u);
	}

	//通过名字查找用户
	@Override
	public UserInfo selectByUserName(String userName) {
		UserInfoExample uie = new UserInfoExample();
		uie.createCriteria().andUserNameEqualTo(userName);

		return userInfoMapper.selectByExample(uie).get(0);
	}

	
	//通过id查找用户
	@Override
	public List<UserInfo> queryUser(int pageIdx) {
		UserInfoExample uie = new UserInfoExample();

		uie.setPageIdx((pageIdx - 1) * 9);
		uie.setOrderByClause("id desc");
		return userInfoMapper.selectByExample(uie);
	}
	//数数
	@Override
	public int countUser() {
		UserInfoExample uie = new UserInfoExample();
		int totalCount = userInfoMapper.countByExample(uie);
		int pageCount = totalCount % 9 == 0 ? totalCount / 9 : totalCount / 9 + 1;
		return pageCount;
	}
	//更新用户
	@Override
	public int updateUser(UserInfo ui) {
		
		
		return userInfoMapper.updateByPrimaryKey(ui);
	}
//添加地址
	@Override
	public int addAddress(Address address) {
		return addressMapper.insert(address);
	}
//更新地址
	@Override
	public int updateAddress(Address address) {
		return addressMapper.updateByPrimaryKey(address);
	}
//删除地址
	@Override
	public int deleteAddress(int addressId) {
		return addressMapper.deleteByPrimaryKey(addressId);
	}

	//通过id查找用户
	@Override
	public UserInfo selectById(int userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}
//添加用户余额
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int addBalance(int userId,BigDecimal amount) {
		UserInfo ui =userInfoMapper.selectByPrimaryKey(userId);
		ui.setBalance(ui.getBalance().add(amount));
		userInfoMapper.updateByPrimaryKeySelective(ui);
		
		BalanceRecord br = new BalanceRecord();
		br.setOperation(0);
		br.setAmount(amount);
		br.setOperateTime(new Date());
		br.setUserId(userId);
		
		
		return balanceRecordMapper.insertSelective(br);
	}

	@Override
	public List<Address> queryAddress(int userId) {
		AddressExample ae = new AddressExample();
		ae.createCriteria().andUserIdEqualTo(userId);
		return addressMapper.selectByExample(ae);
	}

	@Override
	public List<Bankcard> queryBankcard(int userId) {
		BankcardExample be = new BankcardExample();
		be.createCriteria().andUserIdEqualTo(userId);
		return bankcardMapper.selectByExample(be);
	}

	@Override
	public int addBankcard(Bankcard bankcard) {
		return bankcardMapper.insert(bankcard);
	}

	@Override
	public List<BalanceRecord> queryBalanceList(int userId,int pageIdx ) {
		BalanceRecordExample bre = new BalanceRecordExample();
		bre.setPageIdx((pageIdx - 1) * 9);
		bre.createCriteria().andUserIdEqualTo(userId);
		bre.setOrderByClause("id desc");
		return balanceRecordMapper.selectByExample(bre);
	}

	@Override
	public int countBalanceRecord(int userId) {
		BalanceRecordExample bre = new BalanceRecordExample();
		bre.createCriteria().andUserIdEqualTo(userId);
		int totalCount = balanceRecordMapper.countByExample(bre);
		int pageCount = totalCount % 9 == 0 ? totalCount / 9 : totalCount / 9 + 1;
		return pageCount;
	}
	
	

}
