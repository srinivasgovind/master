package io.srinivas.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.srinivas.userbooks.UserBooks;
import io.srinivas.userbooks.UserBooksPrimaryKey;
import io.srinivas.userbooks.UserBooksRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final String COVER_IMAGE_ROOT = "http://covers.openlibrary.org/b/id/";

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserBooksRepository userBooksRepository;

    @GetMapping(value = "/books/{bookId}")
    public Book getBook(@PathVariable String bookId) {
        Book result=new Book();
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();


         result.setId(book.getId());
         result.setName(book.getName());
         result.setPublishedDate(book.getPublishedDate());
         result.setAuthorNames(book.getAuthorNames());

        }
return result;

    }
}
