package com.writo.book.service;


import com.writo.book.dto.BookDTO;
import com.writo.book.exception.BookException;

public interface BookService {

	public BookDTO getBook(Integer bookId) throws BookException;

	public Integer addBook(BookDTO bookDTO);

	public Boolean deleteBook(Integer bookId) throws BookException;

	public Boolean updateBookName(String bookName,Integer bookId) throws BookException;

}
