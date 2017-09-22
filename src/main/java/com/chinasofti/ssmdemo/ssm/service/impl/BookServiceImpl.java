package com.chinasofti.ssmdemo.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.ssmdemo.ssm.dal.dao.BookCommentMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.BookMapper;
import com.chinasofti.ssmdemo.ssm.dal.dao.CategoryMapper;
import com.chinasofti.ssmdemo.ssm.dal.entity.Book;
import com.chinasofti.ssmdemo.ssm.dal.entity.BookComment;
import com.chinasofti.ssmdemo.ssm.dal.entity.BookCommentExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.BookExample;
import com.chinasofti.ssmdemo.ssm.dal.entity.BookExample.Criteria;
import com.chinasofti.ssmdemo.ssm.dal.entity.Cart;
import com.chinasofti.ssmdemo.ssm.dal.entity.Category;
import com.chinasofti.ssmdemo.ssm.dal.entity.CategoryExample;
import com.chinasofti.ssmdemo.ssm.service.BookService;
import com.chinasofti.ssmdemo.ssm.web.BookController;

import ch.qos.logback.classic.Logger;

@Service("BookService")
public class BookServiceImpl implements BookService {

	private static Logger logger = (Logger) LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private BookCommentMapper bookCommentMapper;

	// 查询全部书
	@Override
	public List<Book> queryBook(int pageIdx) {
		BookExample be = new BookExample();
		be.setPageIdx((pageIdx - 1) * 9);
		be.setOrderByClause("id desc");
		return bookMapper.selectByExample(be);
	}

	// 查询全部书的数目s
	@Override
	public int countBook() {
		BookExample be = new BookExample();

		int totalCount = bookMapper.countByExample(be);
		int pageCount = totalCount % 9 == 0 ? totalCount / 9 : totalCount / 9 + 1;
		return pageCount;
	}

	// 添加分类编号的方法
	private List<Integer> addCategoryCondition(Integer categoryId) {
		List<Integer> idList = null;
		if (categoryId != null) {
			idList = new ArrayList<>();
			Category c = categoryMapper.selectByPrimaryKey(categoryId);
			if (c.getParentCategoryId() == null) {
				CategoryExample ce = new CategoryExample();
				ce.createCriteria().andParentCategoryIdEqualTo(categoryId);
				List<Category> CategoryList = categoryMapper.selectByExample(ce);
				for (Category ca : CategoryList) {
					idList.add(ca.getCategoryId());
				}
			}
			idList.add(categoryId);
		}
		return idList;
	}

	// 带条件的查询书
	@Override
	public List<Book> queryByCategory(Integer pageIdx, Integer categoryId, String name) {
		BookExample be = new BookExample();
		System.out.println("Service层pageIdx: " + pageIdx);
		be.setPageIdx((pageIdx - 1) * 9);
		be.setOrderByClause("id desc");
		Criteria c = be.createCriteria();
		if (categoryId != null &&categoryId!=0) {
			c.andCategoryIdIn(addCategoryCondition(categoryId));
		}
		if (name != null&& name.length()>0) {
			c.andNameLike("%" + name + "%");
		}
		return bookMapper.selectByExample(be);
	}

	// //带条件的查询书数目s
	public int countBook(Integer categoryId, String name) {
		BookExample be = new BookExample();
		Criteria c = be.createCriteria();
		if (categoryId != null&&categoryId!=0) {
			c.andCategoryIdIn(addCategoryCondition(categoryId));
		}
		if (name != null && name.length()>0) {
			c.andNameLike("%" + name + "%");
		}
		int totalCount = bookMapper.countByExample(be);
		int pageCount = totalCount % 9 == 0 ? totalCount / 9 : totalCount / 9 + 1;
		return pageCount;
	}

	// 书名查找书籍信息
	public List<Book> BookIdQuery(int bookId) {
		BookExample be = new BookExample();
		Criteria c = be.createCriteria().andBookIdEqualTo(bookId);
		List<Book> b = bookMapper.selectByExample(be);
		logger.info("取出书籍详情" + b.get(0));
		;
		return b;
	}

	public List<Category> queryByFirstId(Integer id) {
		CategoryExample ce = new CategoryExample();
		if (id == null) {
			ce.createCriteria().andParentCategoryIdIsNull();
			return categoryMapper.selectByExample(ce);
		} else {
			ce.createCriteria().andParentCategoryIdEqualTo(id);
			return categoryMapper.selectByExample(ce);
		}
	}

	@Override
	public List<BookComment> queryComment(int bookId) {
		BookCommentExample bce = new BookCommentExample();
		bce.setOrderByClause("id desc");
		logger.info("*%*%*%*%*%*%*%*%*传入查询评价的id:" + bookId);
		bce.createCriteria().andBookIdEqualTo(bookId);
		List<BookComment> bc = bookCommentMapper.selectByExample(bce);
		logger.info("*%*%*%*%*%*%*%*%*取出全部评价:" + bc);
		return bc;
	}

}
