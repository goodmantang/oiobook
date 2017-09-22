package com.chinasofti.ssmdemo.ssm.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.ssmdemo.ssm.dal.entity.UserInfo;

@Controller
@RequestMapping("service")
public class ServicecController {
	private static Logger logger = LoggerFactory.getLogger(ServicecController.class);

	@Autowired
	private UserController uc;

	@RequestMapping("login")
	public String login(UserInfo ui, HttpServletRequest request) {
		
		if (ui.getPassword() == null || ui.getPassword().length() < 6||ui.getUserName()==null||ui.getUserName().length()<6) {
			System.out.println("用户名或密码格式不正确!");
			return "";
		}
		if (!uc.check(ui)) {
			System.out.println("用户名或密码错误!");
			return "";
		}
		
		request.getSession().setAttribute("userId",ui.getUserName());
		logger.info("登录用户名 : "+ui.getUserName());
		
		return "lalala";
	}
	
/*	@RequestMapping
	public String login(){
		return "";
	}*/
	@RequestMapping("modifyuser")
	public String modifyuser(){
		return "modifyuser";
	}
	
}