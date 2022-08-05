package com.writo.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.writo.book.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
