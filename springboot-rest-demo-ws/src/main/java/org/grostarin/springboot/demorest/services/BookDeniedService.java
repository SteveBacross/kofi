/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grostarin.springboot.demorest.services;

import org.grostarin.springboot.demorest.domain.BookDenied;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.exceptions.BookIdMismatchException;
import org.grostarin.springboot.demorest.exceptions.BookNotFoundException;
import org.grostarin.springboot.demorest.repositories.BookDeniedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author Steeve
 */
@Service
public class BookDeniedService {

    @Autowired
    private BookDeniedRepository bookDeniedRepository;

    public Iterable<BookDenied> findAll(BookSearch bookSearchDTO) {
        if (bookSearchDTO != null && StringUtils.hasText(bookSearchDTO.title())) {
            return bookDeniedRepository.findByTitle(bookSearchDTO.title());
        }
        return bookDeniedRepository.findAll();
    }

    public BookDenied findOne(long id) {
        return bookDeniedRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    public BookDenied create(BookDenied book) {
        BookDenied book1 = bookDeniedRepository.save(book);
        return book1;
    }

    public void delete(long id) {
        bookDeniedRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookDeniedRepository.deleteById(id);
    }

    public BookDenied updateBook(BookDenied book, long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookDeniedRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookDeniedRepository.save(book);
    }
}
