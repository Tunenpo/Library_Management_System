package com.example.MiniLibrary.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Valid
@Getter
@Entity(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @NotBlank(message = "Enter the title of the book")
    private String title;

    @Setter
    @NotBlank(message = "Enter the name of the author")
    private String author;

    @Setter
    @NotBlank(message = "Enter the isbn  number")
    @Column(unique = true)
    private String isbn;

    @Setter
    @NotBlank(message = "Enter the publication year")
    private int publicationYear;

    public Book(Long id, String title, String author, String isbn, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public Book() {

    }
}
