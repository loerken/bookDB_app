package com.myapp.bookDB_app.service;

import com.myapp.bookDB_app.model.Book;
import com.myapp.bookDB_app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooksSortedByAuthor() {
        return bookRepository.findAllByOrderByAuthorAsc();
    }

    public List<Book> searchBooks(String author, String title, String genre, int publicationYear) {
        return bookRepository.findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCaseOrGenreContainingIgnoreCaseOrPublicationYear(author, title, genre, publicationYear);
    }
}
