package com.yannitech.api.bookstore.controller;

import com.yannitech.api.bookstore.dao.domain.BookStore;
import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.dao.entity.Category;
import com.yannitech.api.bookstore.dao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1",
        produces = {
                APPLICATION_JSON_VALUE
        })

public class BookController {

    @Autowired
    BookService bookService;

    public BookController(final BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(value = "/book",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Book> viewAllBook(){
        return bookService.getBooks();
    }

    @PostMapping (value = "/saveBook",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping (value = "/saveAuthor",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Author saveAuthor(@RequestBody Author authors){
        return bookService.addAuthor(authors);
    }

    @PostMapping (value = "/saveCategory",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Category saveCategory(@RequestBody Category categories){
        return bookService.addCategory(categories);
    }

    @GetMapping(value = "/book/{id}",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book getBookById(@PathVariable("id") Long id){
        return bookService.getBooksById(id);
    }

    @GetMapping(value = "/bookStore",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<BookStore> getAllBook(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/book/{title}",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getBookByName(String title){
        return bookService.getBook(title);
    }

}
