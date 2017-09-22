package com.chinasofti.ssmdemo.ssm.service;

import java.math.BigDecimal;
import java.util.List;

import com.chinasofti.ssmdemo.ssm.dal.entity.Address;
import com.chinasofti.ssmdemo.ssm.dal.entity.BalanceRecord;
import com.chinasofti.ssmdemo.ssm.dal.entity.Bankcard;
import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfo;

public interface UserService {
int add(UserInfo u);
UserInfo selectByUserName(String userName);
List<UserInfo> queryUser(int pageIdx);
int countUser();
int updateUser(UserInfo ui);
int addAddress(Address address);
int updateAddress(Address address);
int deleteAddress(int addressId);
UserInfo selectById(int userId);
int addBalance(int userId,BigDecimal amount);
List<Address> queryAddress(int userId);
List<Bankcard> queryBankcard(int userId);
int addBankcard(Bankcard bankcard);
List<BalanceRecord> queryBalanceList(int userId,int pageIdx);
int countBalanceRecord(int userId);
}
