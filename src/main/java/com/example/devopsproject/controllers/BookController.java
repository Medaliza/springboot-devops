package com.example.devopsproject.controllers;

import com.example.devopsproject.models.Owner;
import com.example.devopsproject.models.Pet;
import com.example.devopsproject.services.OwnerService;
import com.example.devopsproject.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<book> getBooks()
    {
        List<book> bookList = this.bookService.getBooks();
        return bookList;
    }


    @GetMapping("/{bookID}")
    public book getBookByID(@PathVariable("bookID") Long bookID) throws Exception
    {
        Book book = this.bookService.getbookByID(bookID);
        return book;
    }

    @PostMapping("/create/{ownerId}")
    public Book createNewBook(@RequestBody Book newBook, @PathVariable("ownerId") Long ownerId)
    {
        Book book = this.bookService.createBook(newBook, ownerId);
        return book;
    }

}