package com.yannitech.api.bookstore.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private Long id;
    private String category;
    private String title;
    private String language;
    private String year;
    private Float price;

  //  private Long authorId;

}
