package com.yannitech.api.bookstore.controller;

import com.yannitech.api.bookstore.model.BookDetail;
import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.service.BookService;
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

    @GetMapping(value = "/books",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Book> viewAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping (value = "/saveBook",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping(value = "/authors",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<Author> getAuthors(){
        return bookService.getAllAuthor();
    }

    @PostMapping (value = "/saveAuthor",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Author saveAuthor(@RequestBody Author authors){
        return bookService.addAuthor(authors);
    }

    /*
    @GetMapping(value = "/book/{id}",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book getBookById(@PathVariable("id") Long id){
        return bookService.getBooksById(id);
    }
*/
    @GetMapping(value = "/bookStore",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<BookDetail> getAllBook(){
        return bookService.getBookDetails();
    }

    /*
    @GetMapping(value = "/book/{title}",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getBookByName(String title){
        return bookService.getBook(title);
    }
*/
}
