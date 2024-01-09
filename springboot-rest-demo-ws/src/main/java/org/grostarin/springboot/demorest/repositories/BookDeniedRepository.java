/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.grostarin.springboot.demorest.repositories;

import org.grostarin.springboot.demorest.domain.Book;
import org.grostarin.springboot.demorest.domain.BookDenied;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steeve
 */
@Repository
public interface BookDeniedRepository extends JpaRepository <BookDenied, Long>{

    public Iterable<BookDenied> findByTitle(String title);

    public BookDenied save(Book book);
    
}
