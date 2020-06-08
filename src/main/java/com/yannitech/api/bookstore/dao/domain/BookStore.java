package com.yannitech.api.bookstore.dao.domain;

import com.yannitech.api.bookstore.dao.entity.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookStore {

    private String title;
    private String year;
    private Float price;
    private List<Author> authors;
    private String category;
}
