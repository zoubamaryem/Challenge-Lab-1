package com.example.book_api.service;

import com.example.book_api.model.Book;
import com.example.book_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String isbn, Book book) {
        if (bookRepository.existsById(isbn)) {
            book.setIsbn(isbn);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
