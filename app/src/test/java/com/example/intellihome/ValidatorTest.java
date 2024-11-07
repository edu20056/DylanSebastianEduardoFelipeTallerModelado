package com.example.intellihome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import java.time.LocalDate;

public class ValidatorTest {
    private Validator validator;

    @Mock
    private Context mockContext;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new Validator(mockContext);
    }

    @Test
    public void Test1ValidarPassword() {
        String password = "ValidPass1!";
        assertTrue(validator.validarPassword(password));
    }

    @Test
    public void Test2ValidarPassword() {
        String password = "InvalidPass1";
        assertFalse(validator.validarPassword(password));
    }

    @Test
    public void Test3ValidarPassword() {
        String password = "val1p!";
        assertFalse(validator.validarPassword(password));
    }

    @Test
    public void Test1VerificarEdad() {
        int day = 1, month = 1, year = LocalDate.now().getYear() - 20;
        assertTrue(validator.verificarEdad(day, month, year));
    }
    
    @Test
    public void Test2VerificarEdad() {
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear() - 18;
        assertTrue(validator.verificarEdad(day, month, year));
    }

    @Test
    public void Test3VerificarEdad() {
        int day = 1, month = 1, year = LocalDate.now().getYear() - 17;
        assertFalse(validator.verificarEdad(day, month, year));
    }
}
