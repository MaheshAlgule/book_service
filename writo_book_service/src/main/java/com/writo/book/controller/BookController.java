package com.writo.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.writo.book.dto.BookDTO;
import com.writo.book.exception.BookException;
import com.writo.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;


	@GetMapping("/{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable("bookId") int bookId) throws BookException {
		BookDTO bookDTO = bookService.getBook(bookId);
		return new ResponseEntity<>(bookDTO, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Integer> addBook(BookDTO bookDTO) {
		Integer bookId = bookService.addBook(bookDTO);
		return new ResponseEntity<>(bookId, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> updateBookName(@RequestParam("bookName") String bookName, @RequestParam("bookId") int bookId ) throws BookException {
		Boolean boolean1 = bookService.updateBookName(bookName, bookId);
		return new ResponseEntity<>(boolean1, HttpStatus.OK);
	}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<Boolean> deleteBook(int bookId) throws BookException {
		Boolean boolean1 = bookService.deleteBook(bookId);
		return new ResponseEntity<>(boolean1, HttpStatus.OK);

	}

}
