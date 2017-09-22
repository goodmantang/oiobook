package com.chinasofti.ssmdemo.ssm.dal.domain;

import java.util.List;

import com.chinasofti.ssmdemo.ssm.dal.entity.Address;
import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfo;

public class User {
private UserInfo userInfo;
private List<Address> address;
public UserInfo getUserInfo() {
	return userInfo;
}
public void setUserInfo(UserInfo userInfo) {
	this.userInfo = userInfo;
}

public List<Address> getAddress() {
	return address;
}
public void setAddress(List<Address> address) {
	this.address = address;
}
@Override
public String toString() {
	return "User [userInfo=" + userInfo + ", address=" + address + "]";
}
}
