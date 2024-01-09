/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grostarin.springboot.demorest.controllers;

import javax.validation.Valid;
import org.grostarin.springboot.demorest.annotations.LogExecutionTime;
import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.domain.BookDenied;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.services.BookDeniedService;
import org.grostarin.springboot.demorest.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Steeve
 */
@RestController
@RequestMapping("/api/bookdenied")
public class BookDeniedController {

    @Autowired
    private BookDeniedService bookServices;

    @GetMapping
    @LogExecutionTime
    public Iterable<BookDenied> findAll(@Valid BookSearch bookSearchDTO) {
        return bookServices.findAll(bookSearchDTO);
    }

    @GetMapping("/{id}")
    public BookDenied findOne(@PathVariable long id) {
        return bookServices.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDenied create(@RequestBody BookDenied book) {
        return bookServices.create(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookServices.delete(id);
    }

    @PutMapping("/{id}")
    public BookDenied updateBook(@RequestBody BookDenied book, @PathVariable long id) {
        return bookServices.updateBook(book, id);
    }

}
