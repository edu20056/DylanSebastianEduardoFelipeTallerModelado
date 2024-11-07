package com.example.intellihome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import android.content.Context;
import android.widget.DatePicker;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

public class Test2validarContraseñasIguales {
    private Validator validator;

    @Mock
    private Context mockContext;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        validator = new Validator(mockContext); // Inicializamos el validator con el mockContext
    }

    @Test
    public void testContraseñasIguales() {
        String password = "password123";
        String repeatPassword = "password123"; // Las contraseñas coinciden

        // Llamamos a la función para validar las contraseñas
        boolean result = validator.validarContraseñasIguales(password, repeatPassword);

        assertTrue(result); // Las contraseñas coinciden, el resultado debe ser true
    }

    @Test
    public void testContraseñasNoIguales() {
        String password = "password123";
        String repeatPassword = "password321"; // Las contraseñas coinciden

        // Llamamos a la función para validar las contraseñas
        boolean result = validator.validarContraseñasIguales(password, repeatPassword);

        assertFalse(result); // Las contraseñas coinciden, el resultado debe ser true
    }

    @Test
    public void testContraseñasVacias() {
        String password = "";
        String repeatPassword = ""; // Las contraseñas están vacías

        // Llamamos a la función para validar las contraseñas
        boolean result = validator.validarContraseñasIguales(password, repeatPassword);

        assertTrue(result); // Las contraseñas están vacías, el resultado debe ser false
    }
}


