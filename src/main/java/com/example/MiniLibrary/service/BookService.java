package com.example.MiniLibrary.service;

import com.example.MiniLibrary.model.Book;
import com.example.MiniLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {//model -> repository -> service -> controller

    public BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Cacheable("getAllBooks")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    @Cacheable("getBooksById")
    public Book getBookById(Long id){
        Optional<Book> optionalBook = bookRepository.findById(String.valueOf(id));
        return optionalBook.orElse(null);
    }
    @CacheEvict(value = {"getAllBooks", "getBookById"}, allEntries = true)
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    @CacheEvict(value = {"getAllBooks", "getBookById"}, allEntries = true)
    public Book updateBook(Long id, Book updatedBook){
        Optional<Book> optionalExistingBook = bookRepository.findById(String.valueOf(id));
        if (optionalExistingBook.isPresent()){
            Book existingBook = optionalExistingBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setPublicationYear(updatedBook.getPublicationYear());
            return existingBook; // No need to call save for updates
        } else {
            return null;
        }
    }


    @CacheEvict(value = {"getAllBooks", "getBookById"}, allEntries = true)
    public boolean deleteBook(String isbn) {
        return bookRepository.deleteByIsbn(isbn) > 0;
    }
     @CacheEvict(value = {"getAllBooks", "getBookById"},allEntries = true)
     public void borrowBook(Long userId, Long bookId){

     }

    public List<Book> searchBooks(String title, String author, String isbn) {
        return bookRepository.findByTitleContainingAndAuthorContainingAndIsbnContaining(title, author, isbn);
    }
}
