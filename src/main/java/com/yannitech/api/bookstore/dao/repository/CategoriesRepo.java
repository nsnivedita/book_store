package com.yannitech.api.bookstore.dao.repository;

import com.yannitech.api.bookstore.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Category, Long> {
    Category findBookByCategoryId(Long s);
}
