package org.charles.springboot.elasticsearch.controller;

import org.charles.springboot.elasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private BookService bookService;

    @GetMapping("/create")
    public String create() throws Exception {
        bookService.createIndex();
        return "search";
    }

    @GetMapping("/update")
    public boolean update() throws Exception {
        return  bookService.updateBook();
    }

    @GetMapping("/search")
    public String search() throws Exception {
        bookService.updateBook();
        return "search";
    }
}
