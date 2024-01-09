/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.grostarin.springboot.demorest.tests;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.grostarin.springboot.demorest.domain.BookDenied;
import org.grostarin.springboot.demorest.services.BookDeniedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

/**
 *
 * @author Steeve
 */
@SpringBootTest
public class BookDeniedServiceTests {
    @Autowired
    private BookDeniedService bookDeniedService;
    
    @Test
    public void testCreationNoAttributes() {
        BookDenied toCreate = new BookDenied();
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy( () -> bookDeniedService.create(toCreate));
    }
}
