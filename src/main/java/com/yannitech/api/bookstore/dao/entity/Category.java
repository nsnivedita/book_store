package com.yannitech.api.bookstore.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SequenceGenerator(name="seq1", initialValue=1, allocationSize=100)
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq1")
    private Long categoryId;
    private String category;
}
