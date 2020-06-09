package com.yannitech.api.bookstore;

import com.yannitech.api.bookstore.service.BookService;
import com.yannitech.api.bookstore.util.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BookStoreApplication {

	@Autowired
	BookService bookService;

	@PostConstruct
	private void init() {
		FileReader reader = new FileReader(bookService);
		reader.xmlReader();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);

	}

}
