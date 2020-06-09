package com.yannitech.api.bookstore.model;

import com.yannitech.api.bookstore.dao.entity.Author;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
public class BookDetail {

    private String category;
    private String title;
    private String language;
    private String year;
    private Float price;
    private List<Author> authors;

}
