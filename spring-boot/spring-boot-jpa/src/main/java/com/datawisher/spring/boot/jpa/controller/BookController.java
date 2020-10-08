package com.datawisher.spring.boot.jpa.controller;

import com.datawisher.spring.boot.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/findAll")
    public void findAll() {

    }
}
