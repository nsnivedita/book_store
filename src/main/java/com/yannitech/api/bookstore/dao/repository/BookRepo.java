package com.yannitech.api.bookstore.dao.repository;

import com.yannitech.api.bookstore.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

   @Query(value = "select title from Book where id = ?1")
   Book findBookByName(String title);
}


