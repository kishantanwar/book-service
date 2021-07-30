package com.epam.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.book.model.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book>{

}
