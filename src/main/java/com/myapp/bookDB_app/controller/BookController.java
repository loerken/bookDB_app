package com.myapp.bookDB_app.controller;

import com.myapp.bookDB_app.model.Book;
import com.myapp.bookDB_app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(required = false) String author,
                        @RequestParam(required = false) String title,
                        @RequestParam(required = false) String genre,
                        @RequestParam(required = false) Integer publicationYear) {

        List<Book> books;

        if (author != null || title != null || genre != null || publicationYear != null) {
            books = bookService.searchBooks(author, title, genre, publicationYear != null ? publicationYear : 0);
        } else {
            books = bookService.getAllBooksSortedByAuthor();
        }

        model.addAttribute("books2", books);
        return "index";
    }
}
