package org.grostarin.springboot.demorest.services;

import static java.lang.System.in;
import java.util.LinkedList;
import java.util.List;
import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.domain.BookDenied;
import org.grostarin.springboot.demorest.dto.BookSearch;
import org.grostarin.springboot.demorest.exceptions.BookIdMismatchException;
import org.grostarin.springboot.demorest.exceptions.BookNotFoundException;
import org.grostarin.springboot.demorest.repositories.BookDeniedRepository;
import org.grostarin.springboot.demorest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDeniedRepository bookDeniedRepository;

    public Iterable<Book> findAll(BookSearch bookSearchDTO) {
        if (bookSearchDTO != null && StringUtils.hasText(bookSearchDTO.title())) {
            return bookRepository.findByTitle(bookSearchDTO.title());
        }
        return bookRepository.findAll();
    }

    public Book findOne(long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    public boolean create(Book book) {
        List<BookDenied> bookDenieds = new LinkedList<>();
        bookDenieds = bookDeniedRepository.findAll();
        if (!bookDenieds.isEmpty()) {
            for (BookDenied bookDenied : bookDenieds) {
                if (book.getTitle().equalsIgnoreCase(bookDenied.getTitle())
                        && book.getAuthor().equalsIgnoreCase(bookDenied.getAuthor())) {
                    return false;
                }
            }
        }
        bookRepository.save(book);
        return true;
    }

    public void delete(long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book, long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }

}
