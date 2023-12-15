package com.example.MiniLibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity(name = "BorrowBook")

public class BorrowBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;

    @Setter
    @NotBlank(message = "Enter the book name")
    private String bookName;

    @Setter
    @NotBlank(message = "Enter the name of the author")
    private String author;

    public BorrowBook(Long id, User user_id, Book book_id, String bookName, String author) {
        Id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.bookName = bookName;
        this.author = author;
    }

    public BorrowBook() {

    }
}
