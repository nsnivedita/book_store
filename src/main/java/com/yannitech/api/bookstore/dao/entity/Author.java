package com.yannitech.api.bookstore.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SequenceGenerator(name="seq2", initialValue=1, allocationSize=100)
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq2")
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long bookId;

    private String authorName;

}
