package com.example.intellihome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import android.content.Context;
import android.widget.Toast;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE, sdk = {28}) // Configura sin manifest y usa SDK 28
public class SebasPruebasUnitarias {

    private Validator validator;
    private Context context;

    @Before
    public void setUp() {
        // Crear un mock de Context usando Mockito
        context = mock(Context.class);

        // Crear instancia de Validator pasando el mock de Context
        validator = new Validator(context);
    }

    @After
    public void tearDown() {
        validator = null;
    }

    // Pruebas unitarias para validarIBAN
    @Test
    public void Test1ValidarIBAN() {
        String validIBAN = "ES9121000418450200051332";
        assertTrue("El IBAN válido debería ser aceptado.", validator.validarIBAN(validIBAN));
    }

    @Test
    public void Test2ValidarIBAN() {
        String invalidIBANCharacters = "ES91@1000418450200051332";
        assertFalse("El IBAN con caracteres no válidos debería ser rechazado.", validator.validarIBAN(invalidIBANCharacters));
    }

    @Test
    public void Test3ValidarIBAN() {
        String shortIBAN = "ES9123";
        assertFalse("El IBAN demasiado corto debería ser rechazado.", validator.validarIBAN(shortIBAN));
    }

    // Pruebas unitarias para validarEmail
    @Test
    public void Test1ValidarEmail() {
        String validEmail = "user.name@example.com";
        assertTrue("El email válido debería ser aceptado.", validator.validarEmail(validEmail));
    }

    @Test
    public void Test2ValidarEmail() {
        String invalidEmailMissingAt = "username.example.com";
        assertFalse("El email sin '@' debería ser rechazado.", validator.validarEmail(invalidEmailMissingAt));
    }

    @Test
    public void Test3ValidarEmail() {
        String invalidEmailExample = "username@example";
        assertFalse("El email sin un dominio válido debería ser rechazado.", validator.validarEmail(invalidEmailExample));
    }
}
