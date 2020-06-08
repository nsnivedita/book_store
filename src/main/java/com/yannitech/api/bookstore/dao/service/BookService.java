package com.yannitech.api.bookstore.dao.service;

import com.yannitech.api.bookstore.dao.domain.BookStore;
import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.dao.entity.Category;

import java.util.List;


public interface BookService {

    List<BookStore> getAllBooks();
    List<Book> getBooks();
    String getBook(String title);
    Book addBook(Book book);
    Author addAuthor(Author authors);
    Category addCategory(Category categories);
    void editBookById(Book book ,Long id);
    void deleteBookById(Long id);
    Book getBooksById(Long id);
    List<Author> getAllAuthors();
    List<Category> getAllCategories();





}
