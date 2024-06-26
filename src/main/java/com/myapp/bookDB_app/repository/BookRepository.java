package com.myapp.bookDB_app.repository;

import com.myapp.bookDB_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByAuthorAsc();

    List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCaseOrGenreContainingIgnoreCaseOrPublicationYear(String author, String title, String genre, int publicationYear);
}
