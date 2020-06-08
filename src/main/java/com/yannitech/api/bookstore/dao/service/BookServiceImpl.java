package com.yannitech.api.bookstore.dao.service;

import com.yannitech.api.bookstore.dao.domain.BookStore;
import com.yannitech.api.bookstore.dao.entity.Author;
import com.yannitech.api.bookstore.dao.entity.Book;
import com.yannitech.api.bookstore.dao.entity.Category;
import com.yannitech.api.bookstore.dao.repository.AuthorRepo;
import com.yannitech.api.bookstore.dao.repository.BookRepo;
import com.yannitech.api.bookstore.dao.repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private CategoriesRepo categoriesRepo;

    @Autowired
    public BookServiceImpl(final AuthorRepo authorRepo, final BookRepo bookRepo, final CategoriesRepo categoriesRepo){
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.categoriesRepo = categoriesRepo;
    }

    @Override
    public Book addBook(Book book){
        bookRepo.save(book);
        return book;
    }
    @Override
    public Author addAuthor(Author authors){
        authorRepo.save(authors);
        return authors;
    }

    @Override
    public Category addCategory(Category categories){
        categoriesRepo.save(categories);
        return categories;
    }

    @Override
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        bookRepo.findAll().forEach(books::add);
        return books;
    }

    @Override
    public List<Author> getAllAuthors(){
        List<Author> authors = new ArrayList<>();
        authorRepo.findAll().forEach(authors::add);
        return authors;
    }


    @Override
    public String getBook(String title){
        bookRepo.findBookByName(title);
        return "title";

    }



    @Override
   public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        categoriesRepo.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public  List<BookStore> getAllBooks(){
        List<BookStore> bookStores = new ArrayList<>();
        List<Book> books = getBooks();
        for (Book book: books){
            BookStore bookStore = new BookStore();
            Category categories = categoriesRepo.findBookByCategoryId(book.getCategoryId());
            bookStore.setCategory(categories.getCategory());
            bookStore.setTitle(book.getTitle());
            bookStore.setPrice(book.getPrice());
            bookStore.setYear(book.getYear());
            bookStore.setAuthors(authorRepo.findByBookId(book.getId()));
            //Authors authors1 = authorRepo.findByAuthorId(book.getAuthorId());
           // bookStore.setAuthor(authors1.getAuthorName());
            bookStores.add(bookStore);


        }
        return  bookStores;
    }

    @Override
    public  void deleteBookById(Long id){
        bookRepo.deleteById(id);
    }

    @Override
    public void editBookById(Book book,Long id){
        bookRepo.save(book);
    }


    public Book getBooksByIds(Long id){
        return bookRepo.findById(id).get();
    }

    public Author getAuthorById(Long id){
        return authorRepo.findByAuthorId(id);
    }

    @Override
    public Book getBooksById(Long id){
        Book book = getBooksByIds(id);
        Author authors = getAuthorById(book.getId());
        authors.getAuthorName();
        return book;

    }


}
