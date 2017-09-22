package com.chinasofti.ssmdemo.ssm.service;

import java.util.List;

import com.chinasofti.ssmdemo.ssm.dal.entity.Book;
import com.chinasofti.ssmdemo.ssm.dal.entity.BookComment;
import com.chinasofti.ssmdemo.ssm.dal.entity.Category;

public interface BookService {
List<Book> queryBook(int pageIdx);
int countBook();
int countBook(Integer categoryId,String name);

List<Book> queryByCategory(Integer pageIdx,Integer categoryId,String name);
List<Book> BookIdQuery(int bookId);
List<BookComment> queryComment(int bookId);

List<Category> queryByFirstId(Integer id);
}
