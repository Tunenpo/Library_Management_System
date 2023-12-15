package com.example.MiniLibrary.controller;

import com.example.MiniLibrary.model.BorrowBook;
import com.example.MiniLibrary.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowed-books")
public class BorrowBookController {

    @Autowired
    private BorrowBookService borrowBookService;

    @PostMapping
    public ResponseEntity<BorrowBook> borrowBook(@RequestBody BorrowBook borrowBook) {
        BorrowBook borrowed = borrowBookService.borrowBook(borrowBook);
        return new ResponseEntity<>(borrowed, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BorrowBook>> getAllBorrowedBooks() {
        List<BorrowBook> borrowedBooks = borrowBookService.getAllBorrowedBooks();
        return new ResponseEntity<>(borrowedBooks, HttpStatus.OK);
    }

    @GetMapping("/{borrowedBookId}")
    public ResponseEntity<BorrowBook> getBorrowedBookById(@PathVariable Long borrowedBookId) {
        BorrowBook borrowedBook = borrowBookService.getBorrowedBookById(borrowedBookId);
        return borrowedBook != null ?
                new ResponseEntity<>(borrowedBook, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{borrowedBookId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long borrowedBookId) {
        borrowBookService.returnBook(borrowedBookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Other methods as needed

}
