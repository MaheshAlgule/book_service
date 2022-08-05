package com.writo.book.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writo.book.dto.BookDTO;
import com.writo.book.entity.Book;
import com.writo.book.exception.BookException;
import com.writo.book.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	public BookRepository bookRepository;

	@Autowired
	public ModelMapper modelMapper;

	private BookDTO convertToDto(Book book) {
		BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
		return bookDTO;
	}

	private Book convertToEntity(BookDTO bookDTO) {
		Book book = modelMapper.map(bookDTO, Book.class);
		return book;
	}

	@Override
	public BookDTO getBook(Integer bookId) throws BookException {

		Optional<Book> bookOptional = bookRepository.findById(bookId);
		Book book = bookOptional.orElseThrow(() -> new BookException("Book no available"));

		BookDTO bookDTO = convertToDto(book);

		return bookDTO;
	}

	@Override
	public Integer addBook(BookDTO bookDTO) {
		System.out.println(bookDTO);
		Book book = convertToEntity(bookDTO);
		Book savedBook = bookRepository.save(book);
		return savedBook.getBookId();
	}

	@Override
	public Boolean updateBookName(String bookName, Integer bookId) throws BookException {

		Optional<Book> bookOptional = bookRepository.findById(bookId);
		Book book = bookOptional.orElseThrow(() -> new BookException("Book no available"));
		book.setBookName(bookName);
		return true;
	}

	@Override
	public Boolean deleteBook(Integer bookId) throws BookException {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		Book book = bookOptional.orElseThrow(() -> new BookException("Book no available"));
		if(book != null) {
			bookRepository.delete(book);
		}
		
		return true;

	}

}
