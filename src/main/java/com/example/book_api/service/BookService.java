package com.example.book_api.service;

import com.example.book_api.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookByIsbn(String isbn);
    Book createBook(Book book);
    Book updateBook(String isbn, Book book);
    void deleteBook(String isbn);
}
