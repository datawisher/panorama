package com.datawisher.spring.boot.jpa.dao;

import com.datawisher.spring.boot.jpa.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> getBooksByAuthorStartingWith(String author);

    List<Book> getBooksByPriceGreaterThan(Float price);

    @Query(value = "select * from t_book where id=(select max(id) from t_book )", nativeQuery =
            true)
    Book getMaxIdBook();

    @Query("select b from t_book b where b.id>:id and b.author=:author")
    List<Book> getBooksByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

    @Query("select b from t_book b where b.id<?2 and b.name like %?1%")
    List<Book> getBooksByIdAndName(String name, Integer id);
}
