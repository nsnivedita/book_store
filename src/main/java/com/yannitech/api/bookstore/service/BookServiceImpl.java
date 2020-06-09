package com.yannitech.api.bookstore.service;

import com.yannitech.api.bookstore.model.BookDetail;
import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.dao.repository.AuthorRepo;
import com.yannitech.api.bookstore.dao.repository.BookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;


    @Autowired
    public BookServiceImpl(final AuthorRepo authorRepo, final BookRepo bookRepo){
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }


    @Override
    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }
    @Override
    public Book getBookById(Long id){
        return bookRepo.findById(id).get();
    }
    @Override
    public Book addBook(Book book){
        return bookRepo.save(book);
    }
    @Override
    public void deleteBook(){
    }
    @Override
    public List<Book> getBookByCategoryName(String name) {
        List<Book> books = new ArrayList<>();
        return books;
    }

    @Override
    public List<Author> getAllAuthor(){
        return authorRepo.findAll();
    }
    @Override
    public Author addAuthor(Author authors){
        return authorRepo.save(authors);
    }
    @Override
    public void deleteAuthor(){
    }

    @Override
    public List<Author> getAuthorByBookId(){
        List<Author> authors = new ArrayList<>();
        return authors;
    }


    @Override
    public  List<BookDetail> getBookDetails(){
        List<BookDetail> bookDetails = new ArrayList<>();
        List<Book> books = getAllBook();

        for (Book book: books){
            BookDetail bookDetail = new BookDetail();
            BeanUtils.copyProperties(book,bookDetail);
            bookDetail.setAuthors(authorRepo.findByBookId(book.getId()));
            bookDetails.add(bookDetail);
        }
        return bookDetails;
    }
}
