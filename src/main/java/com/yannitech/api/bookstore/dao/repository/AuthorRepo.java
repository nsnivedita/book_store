package com.yannitech.api.bookstore.dao.repository;

import com.yannitech.api.bookstore.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{
   /* String findBookByAuthor(String authorName);*/

    //Author findByAuthorId(Long s);

   @Query(value = "select a from Author a where a.bookId = ?1")
   List<Author> findByBookId(Long bookId);
}
