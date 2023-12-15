package com.example.MiniLibrary.repository;

import com.example.MiniLibrary.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {

    List<BorrowBook> findByUserId(Long userId);

    Optional<BorrowBook> findByBookId(Long bookId);

    List<BorrowBook> findByBookName(String bookName);

    List<BorrowBook> findByBookAuthor(String bookAuthor);
}
