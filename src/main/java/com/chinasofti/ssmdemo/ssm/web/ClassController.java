package com.chinasofti.ssmdemo.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此 Controller 仅用来跳转页面
 * @author Administrator
 *
 */
@Controller
@RequestMapping("connect")
public class ClassController {

	@RequestMapping("model")
	public String demo(){
		return "model";
	}
	
	@RequestMapping("myoio")
	public String myoio(){
		return "myOIO";
	}
	
	@RequestMapping("modifyuser")
	public String abc(){
		return "modifyuser";
	}
	
	@RequestMapping("cart")
	public String myShoppingCart(){
		return "myshoppingcart";
	}
	
}
