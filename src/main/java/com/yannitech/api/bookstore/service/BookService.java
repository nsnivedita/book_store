package com.yannitech.api.bookstore.service;

import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.model.BookDetail;

import java.util.List;


public interface BookService {

    List<Book> getAllBook();
    Book addBook(Book book);
    void deleteBook();
    Book getBookById(Long id);
    List<Book> getBookByCategoryName(String name);

    List<Author> getAllAuthor();
    Author addAuthor(Author authors);
    void deleteAuthor();

    List<Author> getAuthorByBookId();

    List<BookDetail> getBookDetails();



}
