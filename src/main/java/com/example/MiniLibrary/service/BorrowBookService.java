package com.example.MiniLibrary.service;

import com.example.MiniLibrary.model.BorrowBook;
import com.example.MiniLibrary.repository.BorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowBookService {

    private final BorrowBookRepository borrowBookRepository;

    @Autowired
    public BorrowBookService(BorrowBookRepository borrowBookRepository) {
        this.borrowBookRepository = borrowBookRepository;
    }

    public BorrowBook borrowBook(BorrowBook borrowBook) {
        // Add logic to handle borrowing a book, e.g., set borrow date, update book status, etc.
        return borrowBookRepository.save(borrowBook);
    }

    public List<BorrowBook> getAllBorrowedBooks() {
        return borrowBookRepository.findAll();
    }

    public BorrowBook getBorrowedBookById(Long borrowedBookId) {
        Optional<BorrowBook> optionalBorrowBook = borrowBookRepository.findById(borrowedBookId);
        return optionalBorrowBook.orElse(null);
    }

    public void returnBook(Long borrowedBookId) {
        // Add logic to handle returning a book, e.g., update return date, book status, etc.
        borrowBookRepository.deleteById(borrowedBookId);
    }

    // Other methods as needed

}
