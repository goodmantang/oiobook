package com.chinasofti.ssmdemo.ssm.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.ssmdemo.ssm.dal.domain.CategoryObject;
import com.chinasofti.ssmdemo.ssm.dal.entity.Address;
import com.chinasofti.ssmdemo.ssm.dal.entity.Bankcard;
import com.chinasofti.ssmdemo.ssm.dal.entity.Book;
import com.chinasofti.ssmdemo.ssm.dal.entity.BookComment;
import com.chinasofti.ssmdemo.ssm.dal.entity.Category;
import com.chinasofti.ssmdemo.ssm.service.BookService;
import com.chinasofti.ssmdemo.ssm.service.UserService;

@Controller
@RequestMapping("book")
public class BookController {
	private static Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bs;
	
	@Autowired
	private UserService us;

	@RequestMapping("query")
	public String queryBook(Integer pageIdx , ModelMap m) {
		System.out.println("pageIdx : "+pageIdx);
		pageIdx = pageIdx==null?1:pageIdx;
		System.out.println(bs.queryBook(pageIdx));
		System.out.println("当前页数 : " + pageIdx + " 数据总页数 : " + bs.countBook());
		List<Book> book = bs.queryBook(pageIdx);
		m.put("book", book);
		m.put("pageIdx", pageIdx);
		m.put("totalPage" ,bs.countBook());
		List<CategoryObject> cList = new ArrayList<>();
		List<Category> c=bs.queryByFirstId(null);
		for(Category cc:c){
			CategoryObject co = new CategoryObject();
			co.setCategory(cc);
			co.setCategoryList(bs.queryByFirstId(cc.getCategoryId()));
			cList.add(co);
		}
		System.out.println(cList);
		m.put("cList", cList);
		return "oiohomepage";
	}

	@RequestMapping("query1")
	public String queryBookByCategory(Integer pageIdx, Integer categoryId, String name,ModelMap m) {
		pageIdx = pageIdx==null?1:pageIdx;
		System.out.println("controller接收到的name : "+name);
		//System.out.println(bs.queryByCategory(pageIdx, categoryId,name));
		//System.out.println("当前页数 : " + pageIdx + " 数据总页数 : " + bs.countBook(categoryId,name));
		List<Book> book = bs.queryByCategory(pageIdx, categoryId,name);
		m.put("book", book);
		m.put("pageIdx", pageIdx);
		m.put("totalPage" ,bs.countBook(categoryId,name));
		System.out.println("totalPage: "+bs.countBook(categoryId,name));
		List<CategoryObject> cList = new ArrayList<>();
		List<Category> c=bs.queryByFirstId(null);
		for(Category cc:c){
			CategoryObject co = new CategoryObject();
			co.setCategory(cc);
			co.setCategoryList(bs.queryByFirstId(cc.getCategoryId()));
			cList.add(co);
		}
		//System.out.println(cList);
		m.put("cList", cList);
		m.put("categoryId", categoryId);
		m.put("name", name);
		
		
		return "oiohomepage";
	}
	
	

	@RequestMapping("query2")
	public String detailedInquiry(int bookId , ModelMap m,HttpServletRequest requset){
		
		logger.info("**********传入的书籍ID："+bookId);
		List<Book> b = bs.BookIdQuery(bookId);
		Book book = b.get(0);
		logger.info("**********取出该本书籍的信息："+book);
		m.put("book", book);
		
		List<BookComment> bc = bs.queryComment(bookId);
		logger.info("*%*%*%*%*%*%*%*%*取出全部评价:"+bc);
		m.put("comment", bc);
		
		int userId = (int)requset.getSession().getAttribute("userId");
		
		List<Address> address=us.queryAddress(userId);
		List<Bankcard> bankcards=us.queryBankcard(userId);
		
		m.put("address", address);
		m.put("bankcard",bankcards);
		
		
		return "bookdetails";
	}
	
	
}
