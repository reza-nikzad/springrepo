package com.reza.demo1.controller;

import com.reza.demo1.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BooksRepository booksRepository;

    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", booksRepository.findAll());
        return "books";
    }
}
